package org.exemple.demo.business.impl.manager;

import org.apache.commons.lang3.mutable.MutableObject;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TransactionHelper {

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    private DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

    public MutableObject<TransactionStatus> beginTransaction() {
        return beginTransaction(null);
    }

    public MutableObject<TransactionStatus> beginTransaction(DefaultTransactionDefinition pDefinition) {
        DefaultTransactionDefinition vDefinition = pDefinition != null ? pDefinition : definition;
        TransactionStatus vStatus = platformTransactionManager.getTransaction(pDefinition);
        return new MutableObject<TransactionStatus>(vStatus);
    }

    public void commit(MutableObject<TransactionStatus> pStatus) {
        if (pStatus != null && pStatus.getValue() != null) {
            pStatus.setValue(null);
            platformTransactionManager.commit(pStatus.getValue());
        }
    }

    public void rollback(MutableObject<TransactionStatus> pStatus) {
        if (pStatus != null && pStatus.getValue() != null) {
            pStatus.setValue(null);
            platformTransactionManager.rollback(pStatus.getValue());
        }
    }
}