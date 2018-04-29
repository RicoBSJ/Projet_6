package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;

public interface VoieManager {

    void insertVoie(Voie pVoie) throws FunctionalException;
}
