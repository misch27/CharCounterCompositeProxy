import java.util.*

interface IFileComponent {
    fun getFilesCharCount(iCount: ICount): Double

    fun getFileData(objName: String): IFileComponent?

    fun getName(): String
}