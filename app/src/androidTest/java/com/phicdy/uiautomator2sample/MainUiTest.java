package com.phicdy.uiautomator2sample;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class MainUiTest {

    @Test
    public void floatingButtonTest() {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Launch MainActivity
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.phicdy.uiautomator2sample");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        // Click floating button
        UiObject2 btn = device.wait(Until.findObject(By.res("com.phicdy.uiautomator2sample:id/fab")), 3000);
        if (btn == null) fail("Floating button was not found");
        btn.click();

        UiObject2 snakeBar = device.wait(Until.findObject(By.res("com.phicdy.uiautomator2sample:id/snackbar_text")), 3000);
        assertNotNull(snakeBar);
        assertThat(snakeBar.getText(), is("Replace with your own action"));
    }
}
