package io.takima.service;

import io.takima.ProjectMOTM.RecordsJDBC;

public class RecordsOnInitService {

    public void onInit(){
        RecordsJDBC recordsJDBC = new RecordsJDBC();

        // Vider la table Employee et la table Motm et Motm_Answer
        recordsJDBC.flushMotmAnsOnInit();
        recordsJDBC.flushEmployeeOnInit();
        recordsJDBC.flushMotmOnInit();


        // Insérer des données au démarrage pour pouvoir bosser dessus en dev
        recordsJDBC.insertRecordsInEmployeeOnInit();
        recordsJDBC.insertRecordsInMotmOnInit();
        recordsJDBC.insertRecordsInMotmAnsOnInit();
    }
}
