package com.npace.kmpdemo.server

object CheesesData {
    data class Cheese(
        val name: String,
        val description: String,
    )

    val cheeses = listOf(
        Cheese(
            "Brie",
            "Brie (/briː/; French: [bʁi]) is a soft cow's-milk cheese named after Brie, " +
            "the French region from which it originated (roughly corresponding to the modern département of Seine-et-Marne). " +
            "It is pale in color with a slight grayish tinge under a rind of white mould. " +
            "The rind is typically eaten, with its flavor depending largely upon the ingredients used and its manufacturing environment. " +
            "It is similar to Camembert, which is native to a different region of France. " +
            "Brie typically contains between 60% and 75% butterfat, slightly higher than Camembert."
        ),
        Cheese(
            "Cheddar",
            "Cheddar cheese (or simply cheddar) is a natural cheese that is relatively hard, " +
            "off-white (or orange if colourings such as annatto are added), and sometimes sharp-tasting. " +
            "Cheddar originates from the English village of Cheddar in Somerset."
        ),
        Cheese(
            "Feta",
            "Feta (Greek: φέτα, féta) is a Greek brined white cheese made from sheep's milk or " +
            "from a mixture of sheep and goat's milk. It is soft, with small or no holes, a compact touch, " +
            "few cuts, and no skin. Crumbly with a slightly grainy texture, it is formed into large blocks and aged in brine. " +
            "Its flavor is tangy and salty, ranging from mild to sharp. Feta is used as a table cheese, " +
            "in salads such as Greek salad, and in pastries, notably the phyllo-based Greek dishes " +
            "spanakopita \"spinach pie\" and tyropita \"cheese pie\"."
        ),
        Cheese(
            "Gouda",
            "Gouda cheese (/ˈɡaʊdə/ ⓘ, US also /ˈɡuːdə/ ⓘ, Dutch: [ˈɣʌudaː] ⓘ; Dutch: Goudse kaas, \"cheese from Gouda\") " +
            "is a creamy, yellow cow's milk cheese originating from the Netherlands. " +
            "It is one of the most popular cheeses worldwide. " +
            "The name is used today as a general term for numerous similar cheeses produced in the traditional Dutch manner."
        ),
        Cheese(
            "Gorgonzola",
            "Gorgonzola (/ˌɡɔːrɡənˈzoʊlə/; Italian pronunciation: [ɡorɡonˈdzɔːla]) " +
            "is a veined PDO Italian blue cheese, made from unskimmed cow's milk. " +
            "It can be buttery or firm, crumbly and quite salty, with a \"bite\" from its blue veining. " +
            "Outside the EU and the countries recognizing the geographical origin protection, " +
            "the name \"Gorgonzola\" can legally be used for similar cheeses, " +
            "with only the full Italian name unambiguously referring to PDO Gorgonzola. " +
            "It is a famously pungent cheese."
        ),
        Cheese(
            "Mozzarella",
            "Mozzarella (English: /ˌmɒtsəˈrɛlə/, Italian: [mottsaˈrɛlla]; Neapolitan: muzzarella [muttsaˈrɛllə]) " +
            "is a southern Italian semi-soft, non-aged cheese traditionally made from Italian buffalo's milk by the pasta filata method." +
            "Fresh mozzarella is generally white but when seasoned it turns to a light yellow depending on the animal's diet. " +
            "Due to its high moisture content, it is traditionally served the day after it is made " +
            "but can be kept in brine for up to a week or longer when sold in vacuum-sealed packages. " +
            "Fresh mozzarella can be heard to make a distinct squeaky sound when it is chewed or rubbed."
        ),
        Cheese(
            "Havarti",
            "Havarti (Danish pronunciation: [hæˈvɑːtsʰi]) or cream havarti (Danish: flødehavarti) is a semisoft Danish cow's milk cheese. " +
            "It can be sliced, grilled, or melted.\n\nHavarti was previously called \"Danish Tilsiter\" after the German cheese type tilsiter. " +
            "Danish production began in 1921. In 1952, the cheese was named Havarti, after Havartigården near Holte, " +
            "where the Danish cheese pioneer Hanne Nielsen worked in the 19th century. " +
            "Among other cheeses, Nielsen created a Tilsit cheese with caraway for King Christian IX of Denmark."
        ),
        Cheese(
            "Kashkaval",
            "Kashkaval[a] is a type of cheese made from cow's milk, sheep's milk or both. " +
            "In Albania, Bulgaria, Kosovo, North Macedonia, Romania and Serbia, " +
            "the term is often used to refer to all yellow cheeses (or even any cheese other than sirene). " +
            "In English-language menus in Bulgaria, kashkaval is translated as \"yellow cheese\" " +
            "(whereas sirene is usually translated as \"white cheese\" or simply \"cheese\")."
        ),
        Cheese(
            "Sirene",
            "Sirene (Bulgarian: сирене [ˈsirɛnɛ]; Serbian: сир/sir; Macedonian: сирење; Albanian: djathë i bardhë) " +
            "also known as \"white brine sirene\" (Bulgarian: бяло саламурено сирене) is a type of brined cheese originating from the Balkans. " +
            "It is made of the milk of goats, sheep, cows, buffalo or a mixture thereof. " +
            "It is slightly crumbly, with at least 46–48% of dry matter containing 44–48% of fat. " +
            "It is commonly produced in blocks, and has a slightly grainy texture. It is used as a table cheese, in salads, and in baking."
        ),
    )
}
