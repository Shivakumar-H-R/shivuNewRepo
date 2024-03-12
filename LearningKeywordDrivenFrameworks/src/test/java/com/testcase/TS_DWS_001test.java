package com.testcase;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.readingkeywords.LearningKeywordFromExcel;

import actions.KeywordActions;

public class TS_DWS_001test {
	@Test
	public void enetringDataintoSearchField() throws EncryptedDocumentException, IOException, InterruptedException {
		ArrayList keywords=LearningKeywordFromExcel.readingKeywords();
		KeywordActions keywordActions=new KeywordActions();
		for(int i=0;i<keywords.size();i++)
		{
			String action=(String) keywords.get(i);
			switch(action)
			{
			case "OpenBrowser":
				keywordActions.launchBrowser();
				break;
			case "Navigate":
				keywordActions.launchUrl();
				break;
			case "EnterData":
				keywordActions.enterData("search", "SmartPhone");
				break;
			case "Click":
				keywordActions.click("searchButton");
				Thread.sleep(2000);
				break;
			case "Quit":
				keywordActions.quite();
				break;
			}
		}
		
	}
}
