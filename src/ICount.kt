import java.io.File

interface ICount {
    fun buildFolderStructure(originalDir: String): FileDataComposite

    fun countChar(file: File, oldCharCount: Double): Double
}