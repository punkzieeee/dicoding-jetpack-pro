package com.punkzieeee.moviecatalogue.utils

import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.remote.response.MovieResponse
import com.punkzieeee.moviecatalogue.data.source.remote.response.TVShowResponse

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity("m1","A Star Is Born","R","10/05/2018","Drama, Romance, Music",75,
                "","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))

        movies.add(MovieEntity("m2","Alita: Battle Angel","PG-13","02/14/2019","Action, Science Fiction, Adventure",72,
                "An angel falls. A warrior rises.","When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg"))

        movies.add(MovieEntity("m3","Aquaman","PG-13","12/21/2018","Action, Adventure, Fantasy",69,
                "Home Is Calling","Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/t/p/w1280/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))

        movies.add(MovieEntity("m4","Bohemian Rhapsody","PG-13","11/02/2018","Music, Drama, History",80,
                "Fearless lives forever","Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movies.add(MovieEntity("m5","Cold Pursuit","R","02/08/2019","Action, Crime, Thriller",57,
                "Meet Nels Coxman. Citizen of the Year.","The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))

        movies.add(MovieEntity("m6","Creed II","PG-13","11/21/2018","Drama",69,
                "There's More to Lose than a Title","Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/t/p/w1280/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        movies.add(MovieEntity("m7","Fantastic Beasts: The Crimes of Grindelwald","PG-13","11/16/2018","Adventure, Fantasy, Drama",69,
                "Fate of One. Future of All.","Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movies.add(MovieEntity("m8","Glass","PG-13","01/18/2019","Thriller, Drama, Science Fiction",67,
                "You Cannot Contain What You Are","In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movies.add(MovieEntity("m9","How to Train Your Dragon: The Hidden World","PG","02/22/2019","Animation, Family, Adventure",78,
                "The friendship of a lifetime","As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/t/p/w1280/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"))

        movies.add(MovieEntity("m10","Avengers: Infinity War","PG-13","04/27/2018","Adventure, Action, Science Fiction",83,
                "An entire universe. Once and for all.","As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))

        return movies
    }

    fun generateDummyTVShow(): List<TVShowEntity> {
        val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(TVShowEntity("tv1","Arrow","TV-14",2012,8,"Crime, Drama, Mystery, Action & Adventure", 66,
                "Heroes fall. Legends rise.","Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))

        tvShows.add(TVShowEntity("tv2","Doom Patrol","TV-MA",2019,2,"Sci-Fi & Fantasy, Comedy, Drama", 76,
                "","The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))

        tvShows.add(TVShowEntity("tv3","Dragon Ball","TV-PG",1986,1,"Animation, Action & Adventure, Sci-Fi & Fantasy", 81,
                "","Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "https://www.themoviedb.org/t/p/w1280/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))

        tvShows.add(TVShowEntity("tv4","Fairy Tail","TV-14",2009,8,"Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy", 78,
                "","Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg"))

        tvShows.add(TVShowEntity("tv5","Family Guy","TV-14",1999,19,"Animation, Comedy", 70,
                "Parental Discretion Advised, that's how you know it's good","Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"))

        tvShows.add(TVShowEntity("tv6","The Flash","TV-14",2014,7,"Drama, Sci-Fi & Fantasy", 77,
                "The fastest man alive.","After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"))

        tvShows.add(TVShowEntity("tv7","Gotham","TV-14",2014,5,"Drama, Crime, Sci-Fi & Fantasy", 75,
                "Before Batman, there was Gotham.","Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))

        tvShows.add(TVShowEntity("tv8","Grey's Anatomy","TV-14",2005,17,"Drama", 82,
                "The life you save may be your own.","Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))

        tvShows.add(TVShowEntity("tv9","Hanna","TV-MA",2019,2,"Action & Adventure, Drama", 75,
                "","This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "https://www.themoviedb.org/t/p/w1280/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))

        tvShows.add(TVShowEntity("tv10","Marvel's Iron Fist","TV-MA",2017,2,"Action & Adventure, Drama, Sci-Fi & Fantasy", 66,
                "","Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "https://www.themoviedb.org/t/p/w1280/vXYvfCWvz5W0rErCpNIq09urhzW.jpg"))

        return tvShows
    }

    fun generateRemoteDummyMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse("m1","A Star Is Born","R","10/05/2018","Drama, Romance, Music",75,
            "","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))

        movies.add(MovieResponse("m2","Alita: Battle Angel","PG-13","02/14/2019","Action, Science Fiction, Adventure",72,
            "An angel falls. A warrior rises.","When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg"))

        movies.add(MovieResponse("m3","Aquaman","PG-13","12/21/2018","Action, Adventure, Fantasy",69,
            "Home Is Calling","Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "https://www.themoviedb.org/t/p/w1280/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))

        movies.add(MovieResponse("m4","Bohemian Rhapsody","PG-13","11/02/2018","Music, Drama, History",80,
            "Fearless lives forever","Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movies.add(MovieResponse("m5","Cold Pursuit","R","02/08/2019","Action, Crime, Thriller",57,
            "Meet Nels Coxman. Citizen of the Year.","The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))

        movies.add(MovieResponse("m6","Creed II","PG-13","11/21/2018","Drama",69,
            "There's More to Lose than a Title","Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "https://www.themoviedb.org/t/p/w1280/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        movies.add(MovieResponse("m7","Fantastic Beasts: The Crimes of Grindelwald","PG-13","11/16/2018","Adventure, Fantasy, Drama",69,
            "Fate of One. Future of All.","Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movies.add(MovieResponse("m8","Glass","PG-13","01/18/2019","Thriller, Drama, Science Fiction",67,
            "You Cannot Contain What You Are","In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movies.add(MovieResponse("m9","How to Train Your Dragon: The Hidden World","PG","02/22/2019","Animation, Family, Adventure",78,
            "The friendship of a lifetime","As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://www.themoviedb.org/t/p/w1280/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"))

        movies.add(MovieResponse("m10","Avengers: Infinity War","PG-13","04/27/2018","Adventure, Action, Science Fiction",83,
            "An entire universe. Once and for all.","As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))

        return movies
    }

    fun generateRemoteDummyTVShow(): List<TVShowResponse> {
        val tvShows = ArrayList<TVShowResponse>()

        tvShows.add(TVShowResponse("tv1","Arrow","TV-14",2012,8,"Crime, Drama, Mystery, Action & Adventure", 66,
            "Heroes fall. Legends rise.","Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))

        tvShows.add(TVShowResponse("tv2","Doom Patrol","TV-MA",2019,2,"Sci-Fi & Fantasy, Comedy, Drama", 76,
            "","The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))

        tvShows.add(TVShowResponse("tv3","Dragon Ball","TV-PG",1986,1,"Animation, Action & Adventure, Sci-Fi & Fantasy", 81,
            "","Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/t/p/w1280/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))

        tvShows.add(TVShowResponse("tv4","Fairy Tail","TV-14",2009,8,"Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy", 78,
            "","Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg"))

        tvShows.add(TVShowResponse("tv5","Family Guy","TV-14",1999,19,"Animation, Comedy", 70,
            "Parental Discretion Advised, that's how you know it's good","Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"))

        tvShows.add(TVShowResponse("tv6","The Flash","TV-14",2014,7,"Drama, Sci-Fi & Fantasy", 77,
            "The fastest man alive.","After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"))

        tvShows.add(TVShowResponse("tv7","Gotham","TV-14",2014,5,"Drama, Crime, Sci-Fi & Fantasy", 75,
            "Before Batman, there was Gotham.","Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))

        tvShows.add(TVShowResponse("tv8","Grey's Anatomy","TV-14",2005,17,"Drama", 82,
            "The life you save may be your own.","Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))

        tvShows.add(TVShowResponse("tv9","Hanna","TV-MA",2019,2,"Action & Adventure, Drama", 75,
            "","This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "https://www.themoviedb.org/t/p/w1280/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))

        tvShows.add(TVShowResponse("tv10","Marvel's Iron Fist","TV-MA",2017,2,"Action & Adventure, Drama, Sci-Fi & Fantasy", 66,
            "","Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "https://www.themoviedb.org/t/p/w1280/vXYvfCWvz5W0rErCpNIq09urhzW.jpg"))

        return tvShows
    }
}