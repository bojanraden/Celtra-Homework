
# Celtra-Homework

The configuration and dependencies I have used are visible in the pom.xml file.

I have spent most of the time I had on the environment setup (Appium, Java, Android Studio, Xcode) and how to make everything work together.

I got stuck on both platforms very early in the testing process, on the same step - I wasn't able to switch to the proper   `<iframe>` element to get the modal. I've never encountered  `<iframe>`elements until now.

I was able to get the element's on the initial page (page with Expandable banner) by switching to`driver.switchTo().frame(1);`, unfortunately after that, I tried switching to the other `<iframe>` elements and the children of those elements, but `<celtra-modal>` was nowhere to be found.

For the android project I have used my actual phone LG G7 + chromedriver, and for the iOS project I used a simulator iPhone 8 plus where I had to implement a "SafariLauncher.app", in order to launch Safari.

Project structure:
![project structure](https://i.ibb.co/CH5Rk7V/Screenshot-2020-12-11-at-10-28-42-PM.png)
Both android and iOS files are located in the test folder, under appropriate packages.

I have ran them only through the IDE.

**Extra points questions:**
-how to clean app cache before test:
*I have used the Appium capability* *`cap.setCapability("noReset","true");`  in my tests to clean app cache.*

-how to confirm the banner and expanded units are positioned correctly:
*One of the methods is with the image comparison frameworks, for example "ImageMagick"*.

