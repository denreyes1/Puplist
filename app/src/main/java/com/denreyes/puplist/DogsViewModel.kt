package com.denreyes.puplist

import androidx.lifecycle.ViewModel
import com.denreyes.puplist.data.Dog

class DogsViewModel: ViewModel() {

    fun getDogs() : List<Dog> {
        val dogs = ArrayList<Dog>()
        dogs.add(Dog("rkiByec47", "https://cdn2.thedogapi.com/images/rkiByec47_1280.jpg"))
        dogs.add(Dog("HJRBbe94Q", "https://cdn2.thedogapi.com/images/HJRBbe94Q_1280.jpg"))
        dogs.add(Dog("ryzzmgqE7", "https://cdn2.thedogapi.com/images/ryzzmgqE7_1280.jpg"))
        dogs.add(Dog("WIf5o1E8h", "https://cdn2.thedogapi.com/images/WIf5o1E8h.jpg"))
        dogs.add(Dog("4WiUpv_4W", "https://cdn2.thedogapi.com/images/4WiUpv_4W.jpg"))
        dogs.add(Dog("QWRBrrIvB", "https://cdn2.thedogapi.com/images/QWRBrrIvB.jpg"))
        dogs.add(Dog("M9euOJSBd", "https://cdn2.thedogapi.com/images/M9euOJSBd.jpg"))
        dogs.add(Dog("ERP03yUnq", "https://cdn2.thedogapi.com/images/ERP03yUnq.jpg"))
        dogs.add(Dog("-dncpykkP", "https://cdn2.thedogapi.com/images/-dncpykkP.jpg"))
        dogs.add(Dog("PQxzcr48n", "https://cdn2.thedogapi.com/images/PQxzcr48n.jpg"))
        return dogs
    }
}
