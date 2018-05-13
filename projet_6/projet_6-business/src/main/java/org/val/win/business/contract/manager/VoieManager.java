package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;

import java.util.List;

public interface VoieManager {

    void insertVoie(Voie pVoie) throws FunctionalException;

    List<Voie> getListVoie(Integer id);
}
