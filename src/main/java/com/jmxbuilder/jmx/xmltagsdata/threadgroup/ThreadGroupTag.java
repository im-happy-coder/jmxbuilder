package com.jmxbuilder.jmx.xmltagsdata.threadgroup;

import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.dto.tag.ThreadGroup;
import com.jmxbuilder.jmx.xmltagsdata.transactioncontroll.TransactionTag;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.jmxbuilder.jmx.common
 * fileName       : ExcelNode
 * author         : im-happy-coder
 * date           : 22. 11. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 22.        im-happy-coder       최초 생성
 */
public class ThreadGroupTag {

    // <hashTree>

    //  <TestPlan>

    //  <TestPlan>
    //   <elementProp>
    //    <collectionProp>

    //  <TestPlan>
    //   <stringProp>

    //  <TestPlan>
    //   <boolProp>


    // <hashTree>
    public static ThreadGroupHashTree threadGroupHashTree() {
        ThreadGroupHashTree threadGroupHashTree = new ThreadGroupHashTree();

        List<ThreadGroup> threadGroupList = new ArrayList<>();
        threadGroupList.add(threadGroup());

        List<TransactionHashTree> transactionHashTreeList = new ArrayList<>();
        transactionHashTreeList.add(TransactionTag.transactionHashTree());

        threadGroupHashTree.setThreadGroupList(threadGroupList);
        threadGroupHashTree.setTransactionHashTreeList(transactionHashTreeList);

        return threadGroupHashTree;
    }



    // <ThreadGroup>
    public static ThreadGroup threadGroup() {
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setGuiclass("ThreadGroupGui");
        threadGroup.setTestclass("ThreadGroup");
        threadGroup.setTestname("Thread Group");
        threadGroup.setEnabled("true");

        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(threadElementProp());

        threadGroup.setElementPropList(elementPropList);
        threadGroup.setBoolPropList(tb());
        threadGroup.setStringPropList(ts());
        return threadGroup;
    }

    // <ThreadGroup>
    //   <stringProp>
    public static List<StringProp> ts() {
        StringProp stringProp = new StringProp();
        stringProp.setName("ThreadGroup.on_sample_error");
        stringProp.setValue("continue");

        StringProp stringProp2 = new StringProp();
        stringProp2.setName("ThreadGroup.num_threads");
        stringProp2.setValue("1");

        StringProp stringProp3 = new StringProp();
        stringProp3.setName("ThreadGroup.ramp_time");
        stringProp3.setValue("1");

        StringProp stringProp4 = new StringProp();
        stringProp4.setName("ThreadGroup.duration");
        stringProp4.setValue("");

        StringProp stringProp5 = new StringProp();
        stringProp5.setName("ThreadGroup.delay");
        stringProp5.setValue("");


        List<StringProp> stringPropList = new ArrayList<>();
        stringPropList.add(stringProp);
        stringPropList.add(stringProp2);
        stringPropList.add(stringProp3);
        stringPropList.add(stringProp4);
        stringPropList.add(stringProp5);

        return stringPropList;
    }

    // <ThreadGroup>
    //   <boolProp>
    public static List<BoolProp> tb() {
        BoolProp boolProp = new BoolProp();
        boolProp.setName("ThreadGroup.scheduler");
        boolProp.setValue("false");

        BoolProp boolProp2 = new BoolProp();
        boolProp2.setName("ThreadGroup.same_user_on_next_iteration");
        boolProp2.setValue("true");

        List<BoolProp> boolPropList = new ArrayList<>();

        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);

        return boolPropList;
    }


    // <ThreadGroup>
    //  <elementProp>
    public static ElementProp threadElementProp() {

        ElementProp elementProp = new ElementProp();
        elementProp.setName("ThreadGroup.main_controller");
        elementProp.setElementType("LoopController");
        elementProp.setGuiclass("LoopControlPanel");
        elementProp.setTestclass("LoopController");
        elementProp.setTestname("Loop Controller");
        elementProp.setEnabled("true");

        List<BoolProp> boolPropList = new ArrayList<>();
        boolPropList.add(teb());

        List<StringProp> stringPropList = new ArrayList<>();
        stringPropList.add(tes());

        elementProp.setBoolPropList(boolPropList);
        elementProp.setStringPropList(stringPropList);


        return elementProp;
    }

    // <ThreadGroup>
    //  <elementProp>
    //   <boolProp>
    public static BoolProp teb() {
        BoolProp boolProp = new BoolProp();
        boolProp.setName("LoopController.continue_forever");
        boolProp.setValue("false");

        return boolProp;
    }

    // <ThreadGroup>
    //  <elementProp>
    //   <stringProp>
    public static StringProp tes() {
        StringProp stringProp = new StringProp();
        stringProp.setName("LoopController.loops");
        stringProp.setValue("1");

        return stringProp;
    }

}
