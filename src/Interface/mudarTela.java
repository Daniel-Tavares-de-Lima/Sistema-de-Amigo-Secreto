package Interface;

import java.util.ArrayList;

public class mudarTela {
    
    private static ArrayList<mudanca> listeners = new ArrayList<>();

    public static interface mudanca{
        void mudar(String novaTela, Object userData);
    }

    
}
