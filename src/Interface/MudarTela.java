package Interface;

import java.util.ArrayList;

import Main.Classes.TelasEnum;

public class MudarTela {
    
    private static ArrayList<mudanca> listeners = new ArrayList<>();

    public static interface mudanca{
        void mudar(TelasEnum novaTela, Object userData);
    }

    public static void mudancaListeree(mudanca novaMudanca){
        listeners.add(novaMudanca);
    }

    public static void notificar(TelasEnum novaTela, Object userData){
        for(mudanca m : listeners){
            m.mudar(novaTela, userData);
        }
    }
}
