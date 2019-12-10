package advent

import kotlin.streams.toList

fun main() {
    val imageDataString = "222222022022222222202112210222222222221222202222222222202022222222222222222222022222202222222202110022212122102222222002122220222222222222221222212222222222122122222222222102210222222222222222202222222222202122222222222222222222122222212222222212011222212022002222222012122220222222222222220222202222222222022022222222222202220222222222220222222222222222202122222222222222222222022222202222222212002222212022202222222122222220222222222222220222222222222222122222222222212012210212222222221222222222222222202022222222222222222222022222212202222202200022212022202222222202222221222222222222220222222222222222022122222222202102200202222222221222222222222222222022222222222222222222122222212222222202220022222122002222222102022220222222222222222222212222222222122122222222212102200202222222221222002222222222222222222222222222222222122222222202222212110122202222122222222122022221222222222122221222212222222222222022222222202210202212222222222222002222222222202222222222222222222222222222212212220222002222222122022222222102022221222222222022220222202222222222122022222222212010222202222222222222012222222222212022222222222222222222222222202222220212220222222122022222222022022222222222222122222222212222222222022122222222202221200222222222220222202222222222222122222222222222222222222222202212221212101022222122012222222112122222222222202222220222222222222222222122222222212102222222222222222222212222222222202120222222222222222222022222222212220222022222222222102222222212022222222201222222222222222222222222222122222222222020201202222222222022212222222222222122222222222222222222122222212212221222110122202022012222222002222221222210202222221222222222222222122122222222212201220222222222220022212222222222222020222222222222222222222222222222221202221022202222022222222112222220222202222022221222222222222222222222212222222110221202222222221022102222222222212120222222222222222222022022202212221212220022220122212222222222122221222222202222220222202222222222222222202222222001200222222222222222112122222222212121222222222222222222022222222202220202011122210122112222222012022222222210222222222222202222222222022122122222222121222222222222220222102222222222222221222222222222222222122122222222220222120222222122012222222202222220222212212122222222202222222222222022122222212200222222022222221222012122222222212020222222222222222222122222202202220222010022221022102222222212122220222210212222220222222222222222022222122222202212220202122222222222112022222222222020222222222222222222022222222212220212011022221122122222222212022221222201202022222222212222222222222022102222212221222202222222222022202122222222222020222222222222222222022022222222222212112022211222102222222022222222222222212222221222222222222222122222222222212222210212122222222122222222122222212221222222222222222222222222202212220202121222222122212222222122122221222220222222222222212222222222022222002222202211200202022222221222202122222222212222222222222222222222222022202202222202120022221122202222222102022221222202202122221222202222222222022222012222212102200202122222220022222022022222222122222222222222222222222122222222222212020222221122122222222222222220222200222222220222212222222222222022012222212100222202222222220122122222122222212220222222222222222222222122212220221212102122210022112222222022022222222210222222220222202222222022222022222222202102220212022222220122102122122222222121222222222222222222222122222222221222010222200122122222222112022220222210222122221222222222222222222122102222212200200220222222220022002122122222212020222222222222222222122122222211222222021022201022112222222012122222222202202222220222202222222022022122202222212010202211222222221022002222222222202222222222222222222222122122222212220211012222200222111222222002222221222222202022220222202222222122122022212222222222220222002222221022102022022222202121222222222222222222222222212220222222122022221022200222222002122220222212202222222222212222222222122122222222212101220210122222220022012222022222202021222222222222222222222022212211221200211222220122121222222212022222222200212122222222202222222122222222012222212101220201002222222122102122222222202020222222222222222220022122222200221210202222221022021222222022222221222202212022222222202222222122022022112222202210212211202222222122212122122222212221222222222222222220022022202202221211111022210222121222222102022220222210202022222222222222222222122022212222202001211210102222222022122022222222222022222222222222222221122122212202221201110022202022002222222122222220222200212022220222212222222022222112202222202220211212112222220122222122122222202021222222222222222222222222212222220210112122222022212222222222222222222212222222220221202222222022122212202222202020212222222222221022022222022222222120222222222222222221122222222221221201102122210222212222222122022220222201222022221222222222222122212022012222202102210222202222220222202122122222202120222222222222222221022222202210222222111122210222020222222122122220222220202022221222212222222122122222012222222020222210222222222222112222222222212022222222222222222221022022222212221222001122201122011222222122222221222220222222221222202222222122002212022222212012202222012222220122002222222222212122022222222222222220222122222202221222202222201022001222222112022222222221212022221221022220222222122202202222222012202221012222222122022022022222202120122222222222222221022222202202220211010122211022201222222112222221222220202222221220122222222222222012212222202102212212202222221122222222022222212021122222222222222222122222212210221212012122212122110222222112122222222222212022222221022222222022202222012222212002212202112222221122222222122222222022022222222212222221222121202202222222221022210222020222222222222222212210222222221221112221222122212122102222222000200222102222221022212122122222212022022222222202222220222020222202220211001122220022000222222212222222202220212022221220212222222022222022212222222011221201212222222022212120122222202220122222222222222220022122222212221201222022201222112222222212222221212221212222221220212222222222222202022220222122210222122222222122122120122222202222122222222212222220222222212200221222202122212020022222222222022222212221202122222222112221222222002012102222211210220212122222222022102020122222212120222222222222222220022022212220222202012022201220002222222002222222212212222022221220222222222122012202002220221100211222122222222022202022022222222020022222222222222222022220222220220201000022002221012222222212222221222201222022221221122222222022012112202221212001201201212222222222112121022222222120222222222212222221022121202212221202110122121021212222222012022222212211212022222221212221222222002222202221221022222201122222220122222220222222202021022222222212222221122122202221222201121122101222200222222022122220202222222222221222202220022122121102110220220202200221012222222122102222222222202220022222222222222220222221212201222211110122202122202222222022222021202220212022221220202220222122121202211222222122212201202220222022212220222222202020222222222212222222122120222221220222201022122021021222022112022122212211222022220221122220222222101022002222220221220202102221222222010022222222212221122222222212222221222220222202222201220222112121012022122222122120202201212122222222122220222222112022010221222010200210012221221022000122222222212221122222222222222221022120202220221211102022011221020122222112122022212211212222221221022221022222211112112222220200221222212222220222120121122222212222222222222202222220222022212210220210201222011222111022122012022022222221222122201220212220022222221012011222200212220202012222221122221221022222202222122222202212222220222221202221222210101022120221220022122222122122222210222222202221022220122022000012022222200000202202012222222122110122222222212222122222222212222221022220212200222212202022111221022022122212222202202200212122200222212220122122200012001221221022222210102221220022221020022222202022022222212222222221022021202220221212110222210220112222022022222200222210212222202220012221221122102002120220210202200210112222222122000221122222202221022222212212222220122220202201222220100122010022022122122212122210222201212122222220202221120022200022010220201000212221122220220022122020122222212222022222202212222222122122212212222200102022212020002122022012020012222221222022212220202220021222111122110222210220201200212221221122212100222222212222022222212212222220022202222201220202102222010222222122022102021121222201212222221222102222221222122112202220221002211221122221220122100102222222212020022222212222222221122020202221220210202022202020001222222012021012202210222022201221122222121222010102221220211021222222212221222222202112222222212020122222222222222221022221222210221220100222022222001022022112221022112200202222222221112221120122222022120221220121202221002220222222221212222222222222222222202222222222122002222202222211111122122221002122222002021022112200212022220221222220022222222112022221201211202212122222220222001022122222222022222222202212222222120102222221222211001022012022002122122102120201102210212222201221202220121122222122202222200220221201012220222122111202222222202122022222202222222220120102202201220200111022211120201122022112221021022201222222210220012221020122110002102221211011220212122222222122200220222222212120022222212202222220221221222212221220002022120122010222220102021110012202202022220221202220021122110102211221220201221212122220222122212101022222222022122222202202222202020122202211222211212022020220120122021202222100102201212022200222202220221222122022121221210201202211122220222222100000122222222020222222212222222212021021202201222212010222021221212122220122021200122202202022202222122220120122122112001221201020212200212220222222112211222222222221222222202212222210221120212222220212220122012020201122021012022112112211202222201221112221120122002122211220202000201200022220222022122000022222212121122222202212222221220112222220220011110222020021220002021112220122112221222122210222112220122022002012101222210012222220212222220022111212122222202221022222212202222201022011212201220211012222201221000122022222220002202211212122212220102221222222001102000221222101210220202220220022222110122222002221222222212222222222220100222221221211220022112221012202021022222211222211222122220222012222121022002202001221200120221212002220200122120020122222222120022222212212222222222021212221220212001222012021120012221002121120012201212022212222112222222022101122121222211010201211112221221222202122022222212121022222212222222201222110202220221101210222012021010102022102221011122220202022201220012220120222211212200222220102210202002220221022212001122222202022022222222222222220220122202210220012211022212121021022120102221111112221212122212221022221021122001222110221212222220211102222212022202120122222012022022222222222222210120212202210220221021212220121222102120012122020112201222122222221022222221222001102102220200210220220112221222222120000022222102120222222222212222201102100212210222021000122111120121002020222221000212211202122201220002020220002102222100222221100222201012221221222101020122222212020022222212202222220021020222201221122100112110020220012120022122022012221222122201222222021021112020202121220201012221212122222210222110111122222002121022222212212222202120101202200221012002102221120122112020022020020002221202222201222202221221002122002100221212022201210202222211022212022122222002122122222222202222101011022212220221110200022012021020212022202220200112221112122201221102122222202212102122221211010222220112220210222200220022222002221122022222222222201222211202212220101012102100022100122222022121100022212222122212222122120120002010002101221200201212211102220222222221020022222212121022222202202222100002121202222220221102102000121010212221122121201212201122022201222112022020122201222221220220201202212222222211022021111022222102222222222212212222102002102222211220011021212110121202212020222020212222220222022221222022020021012121002220222201121210210022221211222001220222222222220122222202212222010222000212210222002000012220220102212121110122112222210212022210222212021020002202002010221222211212210022221210222122011122222102120122122222222222200221102212200221110212102102122202102220210020000012211002222212120012121220112112022202221210211202211202220202022222121222222212020222222212202222101000000202220220002211210120120101002220202120001102211012022222121102221220202112112112221210020221221122121202022100012022022022221022022222212222010120210222211220100011201100100212202222220122002102211212022210221200120221212121122020220220112211201002122212022011001222122202012122022222222222201100110212220221100211101222112012200122220122110102220002022221222011121222002020112012222211221210200022021202122110220022122122020022222222202222202102200212210222122202120120222110210220011221210202220222022220120201022122122211022221221212202202210112221200222001212122222012200022022222222222000112021202210222201011200112122201200020022020211112222112122222020002121212122112002210220222221012222112021220122012122222022122000022122212212222002122001212222222020222202011100210120221211102121212200102122111010122020201222021022201220211210011201102122200222020011022022212100222222222202222221021101222211221101001002210002221002222221022022202220212222222212112122221002000012100221200100210201222122210022120222022122002021222222212202222101200200202200221122011211010201222012011200000001102211212122102221011121000122022222202220222001000211222120001122020112022122102021122122212222222122012222222211221200221221011110220210112222211222212211202222200211101122220002112022020222211020200220122220010022200021202222212202122122202212222001221100202222220222212200002110012220112102021222112222202222011001220021000012110112121222220111212220102022220022011001002222222220222022212212222012222101022202220202010110011101102022021012002222122222202122101002000221221002111022021221202121100201212022111222121201002122122121022222202002222021021111202202221122202001112112022102201102200000012212002022210202020021110022111002002221202111211200112221200122021111022222002121022002202022222002021202012210200122021021121112020001112011012110022202012122111211201022021012120102110222212101021211002221111222001202112022102120222012222102212022000221212222221002002110110112122022222020111012212221122222002102211222011002111202220201201011111212012222222022000012002122212002122222212122222212010222222200221022201022112101220112020011221020002222100122201122221022021202122212121202221102212200012221110022022102122222102201021201212222202102102201122212212220212202211220220202222220121220002221001022102122220020101012101012120211201211121210002020001022102220222022022100121121212122222120011220202221221012202010001001212100021100101200112212222122211000001021110200001102201221211111211202222200111222101112022222202220022100212222212111011011212210221121000001100220111122100111221100012201201122100100121020000020121001012121021022002022100212101210020001001100010200101110000210000011111221011020100210122100002120102101100221022202200012021111021211101001"
    val imageData = imageDataString.toCharArray().asList().stream().map { c -> c.toString().toInt() }.toList()
    val width = 25
    val height = 6
    val image = Array(imageData.size / width / height){(Array(height){IntArray(width)})}
    var layerIndex = 0


    for ((i, value) in imageData.withIndex()) {
        val row: Int = i / width % height
        val col = i % width
        image[layerIndex][row][col] = value
        if (row == height - 1 && col == width - 1 && i < imageData.size - 1) {
            layerIndex ++
        }
    }

    val zeros: HashMap<Int,Int> = hashMapOf()
    val ones: HashMap<Int,Int> = hashMapOf()
    val twos: HashMap<Int,Int> = hashMapOf()

    for (i in 0..layerIndex) {
        for (j in 0 until height) {
            for (k in 0 until width) {
                when (image[i][j][k]) {
                    0 -> zeros[i] = zeros.getOrDefault(i, 0) + 1
                    1 -> ones[i] = ones.getOrDefault(i, 0) + 1
                    2 -> twos[i] = twos.getOrDefault(i, 0) + 1
                }
            }
        }
    }

    zeros.forEach { t, u -> println("zero count for layer $t: $u") }
    val layerWithLeastZeros = zeros.filter { v -> v.value == zeros.values.min()}.entries.first().key
    println("layer with least number of zeros: $layerWithLeastZeros")
    val answer = ones[layerWithLeastZeros]!! * twos[layerWithLeastZeros]!!
    println("answer: $answer")

    val finalImage = Array(height){IntArray(width)}
    for (i in 0..layerIndex) {
        for (j in 0 until height) {
            for (k in 0 until width) {
                if (finalImage[j][k] == 2 || i == 0) {
                    finalImage[j][k] = image[i][j][k]
                }
            }
        }
    }

    for (j in 0 until height) {
        for (k in 0 until width) {
            print(if (finalImage[j][k] == 0) "\u25A0" else "\u25A1")
        }
        println()
    }

}