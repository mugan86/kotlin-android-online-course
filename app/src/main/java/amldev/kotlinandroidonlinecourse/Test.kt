package amldev.kotlinandroidonlinecourse

/**
 * Created by anartzmugika on 3/8/17.
 */

//Se puede llamar de otras clases como función global
fun test() {
    //LLamanos a la clase Person

    val person = Person("Anartz", 31)



    val developer = Developer("Aitor")

    val age = developer.age
    val name = developer.name

    println(developer.age)
    println(developer.name)

    val p2 = PersonExtend()
    println(p2.age)
    println(p2.name)

    val pAgeAdd = PersonExtend(age = 25) //Con edad que metemos por parámetro

    println(pAgeAdd.age)
    println(pAgeAdd.name)
}

//Se puede usar como variable en otras clases
var myVar: String = "84"

//Creamos una clase, se crea la clase con un constructor.
//Por defecto la clase es cerrada
data class Person(val name:String, val age: Int) // NO se puede usar como padre para heredar

open class PersonExtend(name: String = "Anartz", val age: Int = 31) {// NO se puede usar como padre para heredar
    // Podemos añadirle valores por defecto para crear un objecto sin valores, cogiendo "Anartz" y 31 como datos
    /*val name: String = name
    val age: Int = age*/ //Esto sería sin añadirle val o var en el constructor

    //Para cambiar el comportamiento de una propiedad (habría que quitar el val o var del constructor en name)
    var name : String = name
        get() = "Name: $field"
    set(value) {
        if(value != field) {
            field = value
        }
    }
}

//No podemos crear una clase heredando de Person si por defecto es cerrada (class Person...),
// creamos open class PersonExtend para ello, y en la propia clase hijo añadimos en el constructor los
// valores que heredaremos como es el caso de nombre. La edad le asignamos en el propio person Extend
class Developer(name: String) : PersonExtend(name, 20)

//Otra manera de crear una clase con varios constructores

class DeveloperTwo: PersonExtend {
    constructor(age: Int): super (age = 20)
    constructor(name: String): super (name)
    constructor(name:String, age: Int) : super()
}

fun testList(lists: List<Person>) {
    //Con desestructurización
    for((name, age) in lists) {
        println("Name: $name / Age: $age")
    }
}