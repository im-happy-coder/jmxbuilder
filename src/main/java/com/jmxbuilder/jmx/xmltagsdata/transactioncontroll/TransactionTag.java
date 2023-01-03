package com.jmxbuilder.jmx.xmltagsdata.transactioncontroll;

import com.jmxbuilder.jmx.dto.tag.BoolProp;
import com.jmxbuilder.jmx.dto.tag.TransactionController;
import com.jmxbuilder.jmx.dto.tag.TransactionHashTree;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.jmxbuilder.jmx.xmltag.transactioncontroll
 * fileName       : TransactionTag
 * author         : im-happy-coder
 * date           : 22. 12. 6.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 6.        im-happy-coder       최초 생성
 */
public class TransactionTag {
    // <HashTree>
    public static TransactionHashTree transactionHashTree() {
        TransactionHashTree transactionHashTree = new TransactionHashTree();
        List<TransactionController> transactionControllerList = new ArrayList<>();

        transactionControllerList.add(transactionController());
        transactionHashTree.setTransactionControllerList(transactionControllerList);

        return transactionHashTree;
    }

    //  <TransactionController>
    public static TransactionController transactionController() {
        TransactionController transactionController = new TransactionController();
        transactionController.setGuiclass("TransactionControllerGui");
        transactionController.setTestclass("TransactionController");
        transactionController.setTestname("Transaction Controller");
        transactionController.setEnabled("true");

        BoolProp boolProp = new BoolProp();
        BoolProp boolProp2 = new BoolProp();

        List<BoolProp> boolPropList = new ArrayList<>();

        boolProp.setName("TransactionController.includeTimers");
        boolProp.setValue("false");
        boolProp2.setName("TransactionController.parent");
        boolProp2.setValue("false");

        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);

        transactionController.setTransactionBoolPropList(boolPropList);

        return transactionController;
    }

    // <TransactionController>
    //  <boolprop>
//    public static BoolProp tbp(TranscationBoolPropType tbp, String value) {
//        BoolProp boolProp = new BoolProp();
//        boolProp.setName(tbp.getName());
//        boolProp.setValue(value);
//
//        return boolProp;
//    }
}
