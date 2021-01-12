import java.io.File
import java.security.NoSuchAlgorithmException

class ProxyCountService(
    private val countService: CountService
) : ICount {
    val countCharMap: MutableMap<File, Double> = mutableMapOf()

    override fun buildFolderStructure(originalDir: String): FileDataComposite {
        return countService.buildFolderStructure(originalDir)
    }

    //using cache for countChar method
    override fun countChar(file: File, oldCharCount: Double): Double {
        val fileDataMap = countCharMap.filterKeys { it.absolutePath == file.absolutePath }
        if (fileDataMap.count() == 0) {
            countCharMap[file] = oldCharCount
            return countCharMap[file]!!
        } else {
            for (fileData in fileDataMap) {
                if (file.lastModified() != file.lastModified()) {
                    val charCount = countService.countChar(file, fileData.value)
                    countCharMap[fileData.key] = charCount
                }
                return countCharMap[fileData.key]!!
            }
        }
        throw NoSuchAlgorithmException()
    }

}