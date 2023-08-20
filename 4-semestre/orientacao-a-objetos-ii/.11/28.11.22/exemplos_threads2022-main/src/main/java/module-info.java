module eic.ifpr.pgua.relatorios {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens ifpr.pgua.eic.threadsjavafx.Exemplo01 to javafx.fxml;
    opens ifpr.pgua.eic.threadsjavafx.Exemplo02 to javafx.fxml;
    opens ifpr.pgua.eic.threadsjavafx.Exemplo03 to javafx.fxml;
    opens ifpr.pgua.eic.threadsjavafx.Exemplo04 to javafx.fxml;
    opens ifpr.pgua.eic.threadsjavafx.Exemplo05 to javafx.fxml;
    opens ifpr.pgua.eic.threadsjavafx.Exemplo6 to javafx.fxml;

    exports ifpr.pgua.eic.threadsjavafx.Exemplo01;
    exports ifpr.pgua.eic.threadsjavafx.Exemplo02;
    exports ifpr.pgua.eic.threadsjavafx.Exemplo03;
    exports ifpr.pgua.eic.threadsjavafx.Exemplo04;
    exports ifpr.pgua.eic.threadsjavafx.Exemplo05;
    exports ifpr.pgua.eic.threadsjavafx.Exemplo6;
}
