package course.design_patterns.singleton;

/**
 * Singleton.
 *
 * Esta clase implementa el patrón de creación de Singleton, en su forma más básica.
 *
 * @author Pablo Hincapie
 */
class Singleton {

    //En esta variable de clase se guardará la referencia al singleton el único objeto de la clase.
    private static Singleton uniqueInstance;

    /**
     * El constructor privado garantiza que no se puedan crear objetos usando "new".
     *
     * Para obtener la instancia debe usarse el método getInstance()
     *
     * */
    private Singleton(){
        //Aquí puede haber código de inicialización de la instancia.
    }

    /**
     * La instancia debe obtenerse, sí o sí, a través de este método.
     * */
    public static Singleton getInstance() {

        //Verificamos que no se haya creado una instancia previamente.
        if(uniqueInstance == null) {
            //Como estamos dentro de la clase, aquí sí podemos usar el constructor, así sea privado.
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }

}
