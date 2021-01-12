import java.io.File
import java.util.*


val fileRegex = Regex("^.*\\.(txt)\$")

class CountService : ICount {
    override fun buildFolderStructure(originalDir: String): FileDataComposite {
        val fileDataTree = FileDataComposite("C:")
        val filePathList = File("/$originalDir").walkTopDown().toList()
        println(filePathList)

        for (file in filePathList) {
            if (fileRegex.containsMatchIn(file.name)) {
                println(file.absoluteFile)
                createIFileComponent(fileDataTree, file)
            }
        }
        return fileDataTree
    }

    private fun createIFileComponent(fileDataTree: FileDataComposite, file: File) {
        val listOfDir = file.absoluteFile.toString().split("\\").toMutableList()
        listOfDir.remove(listOfDir.last())
        listOfDir.remove(listOfDir.first())
        var fileDataComposite: FileDataComposite = fileDataTree
        for (obj in listOfDir) {
            fileDataComposite = fileDataTree.addDir(obj)
        }
        fileDataComposite.addFile(file, countChar(file, 0.0))
    }

    override fun countChar(file: File, oldCharCount: Double): Double {
        val scannerFile = Scanner(file)

        var starNumber = 0 // number of *'s

        while (scannerFile.hasNext()) {
            val character: String = scannerFile.next()
            var index = 0
            while (index < character.length) {
                starNumber++
                index++
            }
        }
        return starNumber.toDouble()
    }

}