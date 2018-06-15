package org.val.win.business.impl.manager;

import org.apache.commons.lang3.mutable.MutableObject;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.CommentaireManager;
import org.val.win.consumer.contract.dao.CommentaireDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Inject
    private CommentaireDao commentaireDao;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recupérer les commentaires d'un topo
     *
     * @param pId
     * @return
     */
    @Override
    public List<Commentaire> getCommentaireTopo(Integer pId) {
        List<Commentaire> pCom = commentaireDao.getCommentaireTopo(pId);
        return pCom;
    }

    @Override
    public void insertCom(Commentaire pCom) throws FunctionalException {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                commentaireDao.insertCommentaire(pCom);
            }
        });
    }
}

