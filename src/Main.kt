fun main(args: Array<String>) {
    val proxyCountService = ProxyCountService(CountService())
    val fileDataCompositeTree = proxyCountService.buildFolderStructure("Test")
    println(fileDataCompositeTree.getFilesCharCount(proxyCountService))
}