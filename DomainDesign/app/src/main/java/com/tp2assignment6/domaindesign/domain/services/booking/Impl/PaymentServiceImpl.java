package com.tp2assignment6.domaindesign.domain.services.booking.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.tp2assignment6.domaindesign.domain.conf.util.App;
import com.tp2assignment6.domaindesign.domain.conf.util.DomainState;
import com.tp2assignment6.domaindesign.domain.domain.booking.Payment;
import com.tp2assignment6.domaindesign.domain.repository.booking.Impl.PaymentRepositoryImpl;
import com.tp2assignment6.domaindesign.domain.repository.booking.Impl.ReservationRepositoryImpl;
import com.tp2assignment6.domaindesign.domain.repository.booking.PaymentRepository;
import com.tp2assignment6.domaindesign.domain.repository.booking.ReservationRepository;
import com.tp2assignment6.domaindesign.domain.repository.user.Impl.UserRepositoryImpl;
import com.tp2assignment6.domaindesign.domain.repository.user.UserRepository;
import com.tp2assignment6.domaindesign.domain.services.booking.PaymentService;

/**
 * Created by NXA-C.unltd on 2016/05/08.
 */

//THIS IS A BOUND LOCAL SERVICE.

public class PaymentServiceImpl extends Service implements PaymentService {
    final private PaymentRepository paymentRepo;
    final private UserRepository userRepo;
    final private ReservationRepository reservationRepo;

    private static PaymentServiceImpl service = null;

    public  static PaymentServiceImpl getInstance(){
        if (service == null)
            service = new PaymentServiceImpl();
        return service;
    }

    public class PaymentServiceLocalBinder extends Binder{
        public PaymentServiceImpl getService(){
            return PaymentServiceImpl.this;
        }
    }

    private final IBinder localBinder = new PaymentServiceLocalBinder();

    private PaymentRepository repo;

    private PaymentServiceImpl(){
        paymentRepo = new PaymentRepositoryImpl(App.getAppContext());
        userRepo = new UserRepositoryImpl(App.getAppContext());
        reservationRepo = new ReservationRepositoryImpl(App.getAppContext());
    }

    @Override
    public String makePayment(String paymentType, String amount) {
        String state = DomainState.NOT_ACTIVATED.name();

        return state;
    }

    @Override
    public boolean isPaymentMade() {
        return repo.readAll().size() > 0;
    }

    @Override
    public boolean terminatePayment() {
        int rows = repo.deleteAll();
        return rows > 0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    private Payment createPayment(Payment payment){
        repo = new PaymentRepositoryImpl(App.getAppContext());
        return repo.update(payment);
    }

}
