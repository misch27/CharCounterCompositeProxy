import java.io.File

data class FileData(
    var file: File,
    var fileCharCount: Double
) : IFileComponent {
    override fun getFilesCharCount(iCount: ICount): Double {
        iCount.countChar(file, fileCharCount)
        return fileCharCount
    }

    override fun getFileData(objName: String): IFileComponent? {
        return this
    }

    override fun getName(): String {
        return file.name
    }

}