package com.amarinag.dadu_fragments

import android.os.Bundle

val dogs: List<Dog> = listOf(
    Dog(
        "f9fc0564913c4230a976361faa321cd7",
        "Pancho",
        "Obediente y tranquilo",
        15,
        "https://upload.wikimedia.org/wikipedia/commons/a/a4/Racib%C3%B3rz_2007_082.jpg"
    ),
    Dog(
        "4b24ae4c4cc04c6aa627e0d45867432b",
        "Bailarín",
        "Fue reconocido como raza en el siglo XIX, aunque su herencia se remonta a algunos miles de años antes de la de los spaniel originales..",
        108,
        "https://thumbs.dreamstime.com/z/perro-bailar%C3%ADn-gracioso-haciendo-trucos-peque%C3%B1o-bailando-activo-fondo-blanco-mascota-divertida-161672443.jpg"
    ),
    Dog(
        "8724da83d9b14db8b027b33f6de75c8e",
        "Cora",
        "Temperamento equilibrado, con nervios firmes, seguro de sí mismo, desenvuelto y (excepto cuando está provocado) amigable",
        36,
        "https://upload.wikimedia.org/wikipedia/commons/a/a4/Racib%C3%B3rz_2007_082.jpg"
    ),
    Dog(
        "df36bf1ef1614dcd849cadb772d2348c",
        "Percha",
        "El Persa es una raza de gato caracterizada por tener una cara ancha y plana y un gran abundante pelaje de variados colores",
        8,
        "https://thumbs.dreamstime.com/z/perro-bailar%C3%ADn-gracioso-haciendo-trucos-peque%C3%B1o-bailando-activo-fondo-blanco-mascota-divertida-161672443.jpg"
    ),
)


/*
companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DogDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        DogDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}
*/