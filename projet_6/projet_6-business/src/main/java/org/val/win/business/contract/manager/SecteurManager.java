package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.exception.FunctionalException;

public interface SecteurManager {

    void insertSecteur(Secteur pSecteur) throws FunctionalException;

}
