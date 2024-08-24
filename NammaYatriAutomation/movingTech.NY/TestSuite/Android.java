package TestSuite;

import org.testng.annotations.Test;
import Driver.AndroidBackButton;
import Driver.DriverLoginFlow;
import Driver.EndRideScreen;
import Driver.EnterOTPPopUp;
import Driver.PopUpScreen;
import Driver.StartRideScreen;
import Driver.DriverCancellation;
import Driver.DriverRatingScreen;
import User.Android.EstimateScreen;
import User.Android.OTPScreen;
import User.Android.RideSearch;
import User.Android.UserLoginFlow;
import User.Android.UserRatingScreen;
import base.BaseClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Android extends BaseClass {

    @Test
    public void sanityrideFlow() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        CyclicBarrier barrier = new CyclicBarrier(2);

        Thread driverThread = new Thread(() -> {
            Thread.currentThread().setName("DriverThread");
            try {
                System.out.println("Driver thread started");
                new DriverLoginFlow().successfulDriverLogin();
                barrier.await(); // 1st barrier: Wait for user login flow to complete
                System.out.println("Driver thread passed first barrier");
                barrier.await(); // 2nd barrier: Wait for user ride search and auto-assign driver to complete
                System.out.println("Driver thread passed second barrier");
                new PopUpScreen().acceptOffer();
                barrier.await(); // 3rd barrier: Wait for user to read OTP
                System.out.println("Driver thread passed third barrier");
           //     new DriverCancellation().cancelRide();
                new StartRideScreen().startRide();
                new EnterOTPPopUp().enterCorrectOTP();
                new AndroidBackButton().tapBack();
                new EndRideScreen().clickEndRide();
                barrier.await(); // 4th barrier
                System.out.println("Driver thread passed fourth barrier");
                new DriverRatingScreen().ratingScreen();
                barrier.await(); // 5th barrier
                System.out.println("Driver thread passed fifth barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("Driver thread finished");
            }
        });

        Thread userThread = new Thread(() -> {
            Thread.currentThread().setName("UserThread");
            try {
                System.out.println("User thread started");
                new UserLoginFlow().successfulUserLogin();
                barrier.await(); // 1st barrier: Wait for driver login flow to complete
                System.out.println("User thread passed first barrier");
                new RideSearch().searchForRideFromSuggestion();
                new EstimateScreen().autoAssignDriver();
                barrier.await(); // 2nd barrier: Wait for driver to reach the 2nd barrier
                System.out.println("User thread passed second barrier");
                new OTPScreen().readOTP();
                barrier.await(); // 3rd barrier: Wait for driver to accept the offer
                System.out.println("User thread passed third barrier");
                
                barrier.await(); // 4th barrier
                System.out.println("User thread passed fourth barrier");
                new UserRatingScreen().ratingScreen();
                barrier.await(); // 5th barrier
                System.out.println("User thread passed fifth barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("User thread finished");
            }
        });

        driverThread.start();
        userThread.start();
        latch.await();
        System.out.println("Both threads finished");
    }
}
