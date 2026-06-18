package clinicajava;

/**
 * Classe principal - ponto de entrada do sistema.
 */
public class Main {

    public static void main(String[] args) {
        // Definir o Look and Feel do sistema para aparência nativa
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            // usa o padrão caso não consiga
        }

        // Abre a tela principal (Menu)
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }
}
