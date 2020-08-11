package com.internetapp.tests;

import com.internetapp.pages.a_ElementsPage;
import com.maveric.core.testng.BaseTest;
import org.testng.annotations.Test;

public class a_Elements extends BaseTest {

	@Test(groups = {"web"})
	public void Test2() throws InterruptedException {

        new a_ElementsPage()
              .navigate("https://demoqa.com/")
 
 //               .checkBox()
 //               .radioButton("Impressive")
 //               .webTables("50")
 //               .Dbutton()
 //               .LinksOps()
                  .browserwindows("NewTab","NewWindow")
                  .Alerts("Promt Alert Message inputted")
                  .Frameselement()
                  .ModalDialogs()
                    .Accordian()
                    .AutoComplete("re","bl")
                    .DatePicker("08/07/2020","12:30PM")
                    .Slider(50)
                    .ProgressBar()
                    .Tabs()
                    .Menu("SUB SUB LIST »","Sub Sub Item 1")
                    .SelectMenu("Green")
                ;
        
        

}
}

