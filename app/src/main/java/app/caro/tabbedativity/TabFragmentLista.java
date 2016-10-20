package app.caro.tabbedativity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class TabFragmentLista extends Fragment {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private String Pelicula[] = new String[]{"DEADPOOL", "INFERNO", "Finding Dory", "Civil War", "The Jungle Book"};
    private String Formato[] = new String[]{"3D", "2D", "3D", "2D", "3D"};
    private String Duracion[] = new String[]{"1h 48m", "2h 1m", "1h 45m", "2h 27m", "1h 51m"};
    private String Sinopsis [] = new String[]{
            "Basado en el anti-héroe menos convencional de Marvel Cómics, Deadpool narra el origen de este ex-agente de las fuerzas especiales, reconvertido en mercenario, que tras pasar por un cruel experimento adquiere poderes sobrenaturales de curación y otras sorprendentes cualidades. Armado con sus nuevas habilidades, y un oscuro y retorcido sentido del humor, Deadpool intentará dar caza al hombre que casi destruye su vida.",
            "El famoso profesor Robert Langdon sigue un misterioso rastro de pistas ligado a la simbología oculta de la Divina Comedia, obra clásica de Dante Alighieri. El Infierno de Dante le arrastrará a un mundo oscuro y tenebroso donde deberá descubrir los secretos mejor guardados de la humanidad. Entre acertijos imposibles, ciencia que pondrá a prueba los límites de la realidad, y uno de los libros con más símbolos ocultos, Langdon se encontrará frente a frente con un oponente a la altura de las circunstancias. Para salir vivo de allí y evitar que el mundo colapse, el profesor deberá llegar al fondo del asunto antes de que sea demasiado tarde.",
            "Siguiendo sus recién recuperados recuerdos, y con el objetivo de reencontrarse con su familia, la divertida pez azul con memoria a corto plazo iniciará un viaje hacia a la costa californiana. Llegará entonces al Instituto de Biología Marina de California, un centro de rehabilitación para la vida marina. Dory descubrirá que allí fue donde nació. Además, en este lugar conocerá a Bailey, una ballena beluga blanca, Destiny, un tiburón ballena, y Hank el pulpo, que se convertirán en sus guías. Sus nuevos compañeros le ayudarán a encontrar a sus padres y a descubrir el verdadero significado de la familia. ",
            "Mientras se produce una guerra civil en el seno de los Vengadores, donde cada uno de ellos debe elegir su bando, aparece la amenaza de un enemigo en las sombras. A pesar de las discordias, y ante el peligro de un nuevo y malvado villano, el equipo de superhéroes tendrá que ponerse en marcha para salvar el mundo. ",
            "El pequeño niño humano emprende un arriesgado y fascinante viaje de autodescubrimiento, para regresar junto a su especie, acompañado de la siempre fiel Bagheera, la pantera mentora del niño, y el despreocupado y divertido oso Baloo. En su camino encontrarán toda clase de aventuras y peligros, además de personajes como Kaa, una seductora serpiente con no muy buenas intenciones que trata de hipnotizarle o al embaucador Rey Louie, que está obsesionado por descubrir el secreto del fuego."};
    private String links[] = new String[]{
            "https://www.youtube.com/watch?v=k4iHpy1z1fg",
            "https://www.youtube.com/watch?v=9gykc1ucfsI",
            "https://www.youtube.com/watch?v=BUc24VVq7wo",
            "https://www.youtube.com/watch?v=qU1-h-KdYdM",
            "https://www.youtube.com/watch?v=bUMNUhfUBbg"};
    private Integer imgid[] = {
            R.drawable.deadpool,
            R.drawable.inferno,
            R.drawable.dory,
            R.drawable.cw,
            R.drawable.mogli
    };

    private String Puntuacion [] = new String[]{"3.5", "4.0", "4.0", "4.5", "3.5"};
    private float puntos [] = new float[]{3, 4, 2, 5, 1};
    private String puntaje [] = new String[]{"3", "4", "2", "5", "1"};





    private ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_fragment_lista, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor = sp.edit();
        LenguajeListAdapter adapter = new LenguajeListAdapter(getActivity(), Pelicula, imgid, Formato);
        lista = (ListView) rootView.findViewById(R.id.mi_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem = Pelicula[+position];
                String SelectedForm = Formato [+position];
                int SelectedImage = imgid [+position];
                String SelectedDuracion = Duracion [+position];
                String sinop = Sinopsis [+position];
                String video = links [+position];

                //String SelectedPuntaje = Puntuacion [+position];
                //String itempuntaje = puntaje [+position];
                float ptos = puntos [+position];


                Toast.makeText(getContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                editor.putString("Movie", Slecteditem).commit();
                editor.putString("Form", SelectedForm).commit();
                editor.putInt("Image",SelectedImage).commit();
                editor.putString("Duracion", SelectedDuracion).commit();
                editor.putString("Sinopsis", sinop).commit();
                editor.putString("Enlaces", video).commit();

                //editor.putString("Puntaje", SelectedPuntaje).commit();
                //editor.putString("Puntuacion", itempuntaje);
                editor.putFloat("Puntos", ptos).commit();







            }
        });



        return rootView;
    }


}