package course.design_patterns.singleton;

/**
 *
 * Singleton (versión thread-safe)
 *
 * Esta clase implementa el patrón de creación de Singleton, garantizando que múltiples hilos tengan siempre la misma
 * instancia.
 *
 * @author Pablo Hincapie
 */
class ThreadSafeSingleton {

    /**
     * En esta variable de clase se guardará la referencia al singleton el único objeto de la clase.
     *
     * Usamos el keyword volatile para garantizar que varios hilos vean de manera consistente la misma referencia a
     * la variable.
     *
     * */
    private volatile static ThreadSafeSingleton uniqueInstance;

    /**
     * El constructor privado garantiza que no se puedan crear objetos usando "new".
     *
     * Para obtener la instancia debe usarse el método getInstance()
     *
     * */
    private ThreadSafeSingleton() {
        //Aquí puede haber código de inicialización de la instancia.
    }

    /**
     * La instancia debe obtenerse, sí o sí, a través de este método.
     * */
    public static ThreadSafeSingleton getInstance() {

        //Verificamos que no se haya creado una instancia previamente.
        if(uniqueInstance == null) {
            /* En caso de que más de un hilo esté tratando de obtener la instancia por primera vez,
             * el bloque sincronizado garantiza que solo un hilo a la vez entre al bloque de código.
             */
            synchronized (ThreadSafeSingleton.class) {
                /*Verificar nuevamente que no haya una instancia previa. Puede que el hilo que haya entrado antes ya
                haya creado la instancia*/
                if(uniqueInstance == null) {
                    //Como estamos dentro de la clase, aquí sí podemos usar el constructor, así sea privado.
                    uniqueInstance = new ThreadSafeSingleton();
                }
            }
        }

        return uniqueInstance;

    }
}
