/**
 * Copyright Pravega Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.pravega.connectors.flink.sink;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PravegaTransactionStateTest {

    private static final String TRANSACTION_ID = "00000000-0000-0000-0000-000000000001";

    @Test
    public void testInit() {
        PravegaTransactionalWriter<Integer> writer = mockPravegaTransactionWriter();
        PravegaTransactionState transactionState = PravegaTransactionState.of(writer);
        assertThat(transactionState.getTransactionId()).isEqualTo(TRANSACTION_ID);
    }

    @SuppressWarnings("unchecked")
    private <T> PravegaTransactionalWriter<T> mockPravegaTransactionWriter() {
        PravegaTransactionalWriter<T> writer = mock(PravegaTransactionalWriter.class);
        when(writer.getTransactionId()).thenReturn(TRANSACTION_ID);
        return writer;
    }
}
