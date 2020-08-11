package com.internetapp.tests;

import org.testng.annotations.Test;

import com.internetapp.pages.Forms;
import com.internetapp.pages.a_ElementsPage;
import com.maveric.core.testng.BaseTest;

public class Formstest extends BaseTest {
	
	@Test(groups = {"web"})
	public void Test3() throws InterruptedException {
		
		//Scenario - Successfully updating Student Registration form
    	//Given <Logged into Demoqa.com URL>
    	//And <I'm in the Forms section>
    	//And <Selected Practice Form sub option>
    	//When <I input the First Name, Last Name, Email, Mobile Number and Current Address in the text fields>
    	//When <I Select the Gender>
    	//When <I Input Date of birth>
    	//When <I Input the Subjects>
    	//When <I Select the Hobbiess>
    	//When <I Select the City>
    	//Then <Submit button is displayed>
		//When <I Click the Submit button>
		//Then <A popup with inputted details displayed>
		//When <I click the Close button>
		//Then Pop up screen is closed 
		
		
        new Forms()
              .navigate("https://demoqa.com/")
                .testBox("Sam", "Martin","rutukantap@maveric-systems.com", "1234567890", "Chennai")
                	.checkBox("Sports","Music")				//options are Sports, Reading & Music
              		.radioButton("Male")					//gender are Male, Female & Other
                    .DatePicker("08/07/2020")
                    .Upload()
                    .AutoComplete("ma","ch","har","kar")    //options are ma, ch, har, kar

                ;
        
        

}
	@Test(groups = {"web"})
	public void Test4() throws InterruptedException {
		
		//Scenario - Successfully updating Student Registration form
    	//Given <Logged into Demoqa.com URL>
    	//And <I'm in the Book Store Application section>
    	//And <Selected Login option>
    	//When <I Input the User Name and Password>
		//And click the Login button
		//Then Navigated to Book Store screen
		//When I input the search box with search word
		//Then Search results matching the search qord displayed
		//When I Click a search keyword
		//Then Navigated to Book Store screen
		//When i Click the Add to your collection Button 
		//Then a Alert message is popped up for confirmation
		//When the Alert pop up is accepted
		//Then the Search item displayed in the Profile screen

        new Forms()
        	.navigate("https://demoqa.com/")
             .BookStoreLogin("hariharaa", "Wewant1!", "java")

                ;
        
	}

}



