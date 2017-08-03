package amldev.kotlinandroidonlinecourse

/**
 * Created by anartzmugika on 3/8/17.
 */

//Se puede llamar de otras clases como función global
fun test() {
    //LLamanos a la clase Person

    val person = Person("Anartz", 31)

    val developer = Developer("Aitor")
}

//Se puede usar como variable en otras clases
var myVar: String = "84"

//Creamos una clase, se crea la clase con un constructor.
//Por defecto la clase es cerrada
class Person(name:String, age: Int) // NO se puede usar como padre para heredar

open class PersonExtend(name:String, age: Int) // NO se puede usar como padre para heredar

//No podemos crear una clase heredando de Person si por defecto es cerrada (class Person...),
// creamos open class PersonExtend para ello, y en la propia clase hijo añadimos en el constructor los
// valores que heredaremos como es el caso de nombre. La edad le asignamos en el propio person Extend
class Developer(name: String) : PersonExtend(name, 20) {
    init{

    }
}