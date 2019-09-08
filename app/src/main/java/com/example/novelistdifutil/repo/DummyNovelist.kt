package com.example.novelistdifutil.repo

import com.example.novelistdifutil.data.Novelist

class DummyNovelist {

    val myList = listOf<Novelist>(
        Novelist(
            0,
            "Alexander Dumas",
            1802,
            "The Count of Monte Cristo",
            "https://en.wikipedia.org/wiki/The_Count_of_Monte_Cristo"
        ),
        Novelist(
            1,
            "Victor Hugo",
            1845,
            "Les Miserables",
            "https://en.wikipedia.org/wiki/Victor_Hugo"
        ),
        Novelist(
            2,
            "Charles Dickens",
            1867,
            "David Copperfield",
            "https://en.wikipedia.org/wiki/Charles_Dickens"
        ),
        Novelist(3, "Jack London", 1876, "White Fang", "https://en.wikipedia.org/wiki/Jack_London"),
        Novelist(
            4,
            "Dan Brown",
            1964,
            "The Da Vinci Code",
            "https://en.wikipedia.org/wiki/Dan_Brown"
        ),
        Novelist(
            5,
            "Paulo Coelho",
            1947,
            "The Alchemist",
            "https://en.wikipedia.org/wiki/Paulo_Coelho"
        ),
        Novelist(
            6,
            "William Ury",
            1953,
            "Getting to Yes",
            "https://en.wikipedia.org/wiki/William_Ury"
        ),
        Novelist(
            7,
            "Guy Kawasaki",
            1954,
            "The Art of the Start",
            "https://en.wikipedia.org/wiki/Guy_Kawasaki"
        ),
        Novelist(
            8,
            "Napoleon Hill",
            1883,
            "Think and grow rich",
            "https://en.wikipedia.org/wiki/Napoleon_Hill"
        ),
        Novelist(
            9,
            "Dan Millman",
            1946,
            "The way of the Peaceful Warrior",
            "https://en.wikipedia.org/wiki/Dan_Millman"
        ),
        Novelist(
            10,
            "Peter Thiel",
            1967,
            "Zero to One",
            "https://en.wikipedia.org/wiki/Peter_Thiel"
        )
    )

    val afterYears: List<Novelist>
        get() = myList.sortedBy { it.year }

    val afterName: List<Novelist>
        get() = myList.sortedBy { it.name }

    val afterNovel: List<Novelist>
        get() = myList.sortedByDescending { it.novel }
}