package com.jmxbuilder.jmx.xmltagsdata.jmetertestplan;

import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.xmltagsdata.threadgroup.ThreadGroupTag;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.jmxbuilder.jmx.xmltags.jmetertestplan
 * fileName       : JmterTestPlanTag
 * author         : im-happy-coder
 * date           : 22. 12. 6.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 6.        im-happy-coder       최초 생성
 */
public class JmeterTestPlanTag {

    // <jmeterTestPlan>
    public static JmeterTestPlan jmeterTestPlan() {
        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        jmeterTestPlan.setVersion("1.2");
        jmeterTestPlan.setProperties("5.0");
        jmeterTestPlan.setJmeter("5.5");

        List<TestPlanHashTree> testPlanHashTreeList = new ArrayList<>();
        testPlanHashTreeList.add(testPlanHashTree());

        jmeterTestPlan.setTestPlanHashTreeList(testPlanHashTreeList);

        return jmeterTestPlan;
    }


    // <hashTree>
    public static TestPlanHashTree testPlanHashTree() {
        TestPlanHashTree testPlanHashTree = new TestPlanHashTree();

        List<TestPlan> testPlanList = new ArrayList<>();
        testPlanList.add(testPlan());

        List<ThreadGroupHashTree> threadGroupHashTreeList = new ArrayList<>();
        threadGroupHashTreeList.add(ThreadGroupTag.threadGroupHashTree());

        testPlanHashTree.setTestPlanList(testPlanList);
        testPlanHashTree.setThreadGroupHashTreeList(threadGroupHashTreeList);

        return testPlanHashTree;
    }

    //  <TestPlan>
    public static TestPlan testPlan() {
        TestPlan testPlan = new TestPlan();
        testPlan.setGuiclass("TestPlanGui");
        testPlan.setTestclass("TestPlan");
        testPlan.setTestname("Test Plan");
        testPlan.setEnabled("true");

        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add((te()));

        testPlan.setElementPropList(elementPropList);
        testPlan.setStringPropList(ts());
        testPlan.setBoolPropList(tb());

        return testPlan;
    }

    //  <TestPlan>
    //   <elementProp>
    public static ElementProp te() {
        ElementProp elementProp = new ElementProp();
        elementProp.setName("TestPlan.user_defined_variables");
        elementProp.setElementType("Arguments");
        elementProp.setGuiclass("ArgumentsPanel");
        elementProp.setTestclass("Arguments");
        elementProp.setTestname("User Defined Variables");
        elementProp.setEnabled("true");

        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(tec());
        elementProp.setCollectionPropList(collectionPropList);

        return elementProp;
    }

    //  <TestPlan>
    //   <elementProp>
    //    <collectionProp>
    public static CollectionProp tec() {
        CollectionProp collectionProp = new CollectionProp();
        collectionProp.setName("Arguments.arguments");

        return collectionProp;
    }



    //  <TestPlan>
    //   <stringProp>
    public static List<StringProp> ts() {
        StringProp stringProp = new StringProp();
        stringProp.setName("TestPlan.comments");
        stringProp.setValue("");

        StringProp stringProp2 = new StringProp();
        stringProp2.setName("TestPlan.user_define_classpath");
        stringProp2.setValue("");

        List<StringProp> stringPropList = new ArrayList<>();
        stringPropList.add(stringProp);
        stringPropList.add(stringProp2);

        return stringPropList;
    }

    //  <TestPlan>
    //   <boolProp>
    public static List<BoolProp> tb() {
        BoolProp boolProp = new BoolProp();
        boolProp.setName("TestPlan.functional_mode");
        boolProp.setValue("false");

        BoolProp boolProp2 = new BoolProp();
        boolProp2.setName("TestPlan.tearDown_on_shutdown");
        boolProp2.setValue("true");

        BoolProp boolProp3 = new BoolProp();
        boolProp3.setName("TestPlan.serialize_threadgroups");
        boolProp3.setValue("false");

        List<BoolProp> boolPropList = new ArrayList<>();
        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);
        boolPropList.add(boolProp3);

        return boolPropList;
    }


}
