import java.io.File

class FileDataComposite(
    val dirName: String
) : IFileComponent {

    private val fileDataList = mutableListOf<IFileComponent>()

    override fun getFilesCharCount(iCount: ICount): Double {
        var sumCharCount = 0.0
        fileDataList.forEach {
            sumCharCount += it.getFilesCharCount(iCount)
        }
        return sumCharCount
    }

    override fun getFileData(objName: String): IFileComponent? {
        var obj: IFileComponent? = null
        for (iFileComponent in fileDataList) {
            if (iFileComponent.getName() == objName) {
                obj = iFileComponent
            }
        }
        return obj
    }

    override fun getName(): String {
        return dirName
    }

    fun addDir(dirName: String): FileDataComposite {
        var dir = getFileData(dirName) as FileDataComposite?
        if (dir == null) {
            fileDataList.add(FileDataComposite(dirName))
            dir = getFileData(dirName) as FileDataComposite
        }
        return dir
    }

    fun addFile(file: File, fileCharCount: Double) {
        val fileData = getFileData(file.name) as FileData?
        if (fileData == null) {
            fileDataList.add(FileData(file = file, fileCharCount = fileCharCount))
        }
    }
}