/*
 * Copyright 2018 rolhai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.racemanager.batch;

import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Named;

@Named(value = "counterBatchlet")
public class CounterBatchlet extends AbstractBatchlet {

    private static final Logger logger = Logger.getLogger(CounterBatchlet.class.getName());

    private static int counter = 0;

    @Override
    public String process() {
        counter++;
        logger.info("Running inside a batchlet for " + counter + " time(s).");
        return BatchStatus.COMPLETED.toString();
    }
}
