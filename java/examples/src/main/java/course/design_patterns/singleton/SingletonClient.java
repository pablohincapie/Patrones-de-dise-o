package course.design_patterns.singleton;

/**
 * Clase que utiliza los objetos singleton.
 *
 * @author Pablo Hincapie
 */

class SingletonClient {

    public static void main(String[] args) {

        //Probemos el Singleton básico

        //Debemos pedirle a la clase el objeto, ya que no podemos usar el constructor al ser privado.
        Singleton objectOne = Singleton.getInstance();
        Singleton objectTwo = Singleton.getInstance();

        System.out.println(objectOne == objectTwo ? "Solo hay una instancia!": "El singleton ha fallado");

        //El Singleton thread-safe se usa exactamente de la misma manera.
        ThreadSafeSingleton threadSafeSingletonOne = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingletonTwo = ThreadSafeSingleton.getInstance();

        System.out.println(threadSafeSingletonOne == threadSafeSingletonTwo ? "Solo hay una instancia thread-safe!":
                "El singleton ha fallado");

    }

}
