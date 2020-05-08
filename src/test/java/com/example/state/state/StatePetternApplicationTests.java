package com.example.state.state;

import com.example.state.DeliveredState;
import com.example.state.OrderedState;
import com.example.state.Package;
import com.example.state.ReceivedState;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

class StatePetternApplicationTests {

    @Test
    public void givenNewPackage_whenPackageReceived_thenStateReceived() {
        Package pkg = new Package();

        assertThat(pkg.getState(), instanceOf(OrderedState.class));
        pkg.nextState();

        assertThat(pkg.getState(), instanceOf(DeliveredState.class));
        pkg.nextState();

        assertThat(pkg.getState(), instanceOf(ReceivedState.class));
    }

    @Test
    public void givenDeliveredPackage_whenPrevState_thenStateOrdered() {
        Package pkg = new Package();
        pkg.setState(new DeliveredState());
        pkg.previousState();

        assertThat(pkg.getState(), instanceOf(OrderedState.class));
    }

}
