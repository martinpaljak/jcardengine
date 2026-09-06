// SPDX-FileCopyrightText: 2025 Martin Paljak <martin@martinpaljak.net>
// SPDX-License-Identifier: Apache-2.0
package com.licel.jcardsim;

import com.licel.jcardsim.base.Simulator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class SimulatorCoreTest {
    // These tests don't create an explicit Simulator instance
    // but the core requires a Simulator.current() instance to exist
    // for transient memory (mostly), so set one up.
    private Simulator.CurrentSimulator sim;

    @BeforeClass
    public void implicitSimulator() {
        sim = new Simulator().asCurrent();
    }

    @AfterClass
    public void releaseSimulator() {
        sim.close();
    }
}
