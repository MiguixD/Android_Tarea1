package com.example.tarea1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tarea1.recycler.Anime

class ListViewModel(): ViewModel() {
    val list = listOf(
        Anime(
            "Mob Psycho 100",
            "Eighth-grader Shigeo \"Mob\" Kageyama has tapped into his inner wellspring of psychic prowess at a young age. But the power quickly proves to be a liability when he realizes the potential danger in his skills. Choosing to suppress his power, Mob's only present use for his ability is to impress his longtime crush, Tsubomi, who soon grows bored of the same tricks.\n" +
                    "\n" +
                    "In order to effectuate control on his skills, Mob enlists himself under the wing of Arataka Reigen, a con artist claiming to be a psychic, who exploits Mob's powers for pocket change. Now, exorcising evil spirits on command has become a part of Mob's daily, monotonous life. However, the psychic energy he exerts is barely the tip of the iceberg; if his vast potential and unrestrained emotions run berserk, a cataclysmic event that would render him completely unrecognizable will be triggered. The progression toward Mob's explosion is rising and attempting to stop it is futile.",
            false
        ),
        Anime(
            "Gintama",
            "Edo is a city that was home to the vigor and ambition of samurai across the country. However, following feudal Japan's surrender to powerful aliens known as the \"Amanto,\" those aspirations now seem unachievable. With the once-influential shogunate rebuilt as a puppet government, a new law is passed that promptly prohibits all swords in public.\n" +
                    "\n" +
                    "Enter Gintoki Sakata, an eccentric silver-haired man who always carries around a wooden sword and maintains his stature as a samurai despite the ban. As the founder of Yorozuya, a small business for odd jobs, Gintoki often embarks on endeavors to help other people—though usually in rather strange and unforeseen ways.\n" +
                    "\n" +
                    "Assisted by Shinpachi Shimura, a boy with glasses supposedly learning the way of the samurai; Kagura, a tomboyish girl with superhuman strength and an endless appetite; and Sadaharu, their giant pet dog who loves biting on people's heads, the Yorozuya encounter anything from alien royalty to scuffles with local gangs in the ever-changing world of Edo.",
            true
        )
    )
    private val _animeFavouriteList = MutableLiveData<List<Anime>>()
    val animeFavouriteList: LiveData<List<Anime>> get() = _animeFavouriteList
    private val _animeList = MutableLiveData<List<Anime>>()
    val animeList: LiveData<List<Anime>> get() = _animeList

    init {
        _animeFavouriteList.value = getFavourites(list)
        _animeList.value = list
    }

    private fun getFavourites(animeList: List<Anime>): List<Anime> {
        return animeList.filter { it.favourite }
    }

    fun toggleFavourite(anime: Anime) {
        anime.favourite = !anime.favourite

        val updatedList = list.map {
            if (it.title == anime.title) it.copy(favourite = anime.favourite) else it
        }

        _animeList.value = updatedList
        _animeFavouriteList.value = getFavourites(updatedList)
    }
}