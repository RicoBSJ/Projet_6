package org.val.win.business.impl.manager;

import org.apache.commons.lang3.mutable.MutableObject;
import org.springframework.transaction.TransactionStatus;
import org.val.win.business.contract.manager.CommentaireManager;
import org.val.win.consumer.contract.dao.CommentaireDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Topo;
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
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recupérer les commentaires d'un topo
     * @param pTopo
     * @return
     */
    @Override
    public List<Commentaire> getCommentaireTopo(Topo pTopo){
        List<Commentaire> pCom = commentaireDao.getCommentaireTopo(pTopo);
        return pCom;
    }

    @Override
    public void insertCom(Commentaire pCom) throws FunctionalException {
        //MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        //try {
            commentaireDao.insertCommentaire(pCom);
         //   transactionHelper.commit(vStatus);
      //  } finally {
     //       transactionHelper.rollback(vStatus);
     //   }
    }
}
