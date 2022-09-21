/*
 * Copyright (c) 2008-2022, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.Generated;
import com.hazelcast.client.impl.protocol.codec.builtin.*;
import com.hazelcast.client.impl.protocol.codec.custom.*;

import javax.annotation.Nullable;

import static com.hazelcast.client.impl.protocol.ClientMessage.*;
import static com.hazelcast.client.impl.protocol.codec.builtin.FixedSizeTypesCodec.*;

/*
 * This file is auto-generated by the Hazelcast Client Protocol Code Generator.
 * To change this file, edit the templates or the protocol
 * definitions on the https://github.com/hazelcast/hazelcast-client-protocol
 * and regenerate it.
 */

/**
 * Adds a new queue configuration to a running cluster.
 * If a queue configuration with the given {@code name} already exists, then
 * the new configuration is ignored and the existing one is preserved.
 */
@Generated("4f18a71a626a782ce8f63f14a497fd40")
public final class DynamicConfigAddQueueConfigCodec {
    //hex: 0x1B0B00
    public static final int REQUEST_MESSAGE_TYPE = 1772288;
    //hex: 0x1B0B01
    public static final int RESPONSE_MESSAGE_TYPE = 1772289;
    private static final int REQUEST_BACKUP_COUNT_FIELD_OFFSET = PARTITION_ID_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_ASYNC_BACKUP_COUNT_FIELD_OFFSET = REQUEST_BACKUP_COUNT_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_MAX_SIZE_FIELD_OFFSET = REQUEST_ASYNC_BACKUP_COUNT_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_EMPTY_QUEUE_TTL_FIELD_OFFSET = REQUEST_MAX_SIZE_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_STATISTICS_ENABLED_FIELD_OFFSET = REQUEST_EMPTY_QUEUE_TTL_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_MERGE_BATCH_SIZE_FIELD_OFFSET = REQUEST_STATISTICS_ENABLED_FIELD_OFFSET + BOOLEAN_SIZE_IN_BYTES;
    private static final int REQUEST_INITIAL_FRAME_SIZE = REQUEST_MERGE_BATCH_SIZE_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int RESPONSE_INITIAL_FRAME_SIZE = RESPONSE_BACKUP_ACKS_FIELD_OFFSET + BYTE_SIZE_IN_BYTES;

    private DynamicConfigAddQueueConfigCodec() {
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
    public static class RequestParameters {

        /**
         * queue name
         */
        public java.lang.String name;

        /**
         * item listeners configuration
         */
        public @Nullable java.util.List<com.hazelcast.client.impl.protocol.task.dynamicconfig.ListenerConfigHolder> listenerConfigs;

        /**
         * number of synchronous backups
         */
        public int backupCount;

        /**
         * number of asynchronous backups
         */
        public int asyncBackupCount;

        /**
         * maximum number of items in the queue
         */
        public int maxSize;

        /**
         * queue time-to-live in seconds: queue will be destroyed if it stays empty or unused for that time
         */
        public int emptyQueueTtl;

        /**
         * {@code true} to enable gathering of statistics, otherwise {@code false}
         */
        public boolean statisticsEnabled;

        /**
         * name of an existing configured split brain protection to be used to determine the minimum number of members
         * required in the cluster for the queue to remain functional. When {@code null}, split brain protection does not
         * apply to this queue configuration's operations.
         */
        public @Nullable java.lang.String splitBrainProtectionName;

        /**
         * backing queue store configuration
         */
        public @Nullable com.hazelcast.client.impl.protocol.task.dynamicconfig.QueueStoreConfigHolder queueStoreConfig;

        /**
         * Classname of the merge policy.
         */
        public java.lang.String mergePolicy;

        /**
         * Number of entries to be sent in a merge operation.
         */
        public int mergeBatchSize;

        /**
         * Class name of the configured {@link java.util.Comparator} implementation.
         */
        public @Nullable java.lang.String priorityComparatorClassName;

        /**
         * True if the priorityComparatorClassName is received from the client, false otherwise.
         * If this is false, priorityComparatorClassName has the default value for its type.
         */
        public boolean isPriorityComparatorClassNameExists;
    }

    public static ClientMessage encodeRequest(java.lang.String name, @Nullable java.util.Collection<com.hazelcast.client.impl.protocol.task.dynamicconfig.ListenerConfigHolder> listenerConfigs, int backupCount, int asyncBackupCount, int maxSize, int emptyQueueTtl, boolean statisticsEnabled, @Nullable java.lang.String splitBrainProtectionName, @Nullable com.hazelcast.client.impl.protocol.task.dynamicconfig.QueueStoreConfigHolder queueStoreConfig, java.lang.String mergePolicy, int mergeBatchSize, @Nullable java.lang.String priorityComparatorClassName) {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        clientMessage.setContainsSerializedDataInRequest(true);
        clientMessage.setRetryable(false);
        clientMessage.setOperationName("DynamicConfig.AddQueueConfig");
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[REQUEST_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, REQUEST_MESSAGE_TYPE);
        encodeInt(initialFrame.content, PARTITION_ID_FIELD_OFFSET, -1);
        encodeInt(initialFrame.content, REQUEST_BACKUP_COUNT_FIELD_OFFSET, backupCount);
        encodeInt(initialFrame.content, REQUEST_ASYNC_BACKUP_COUNT_FIELD_OFFSET, asyncBackupCount);
        encodeInt(initialFrame.content, REQUEST_MAX_SIZE_FIELD_OFFSET, maxSize);
        encodeInt(initialFrame.content, REQUEST_EMPTY_QUEUE_TTL_FIELD_OFFSET, emptyQueueTtl);
        encodeBoolean(initialFrame.content, REQUEST_STATISTICS_ENABLED_FIELD_OFFSET, statisticsEnabled);
        encodeInt(initialFrame.content, REQUEST_MERGE_BATCH_SIZE_FIELD_OFFSET, mergeBatchSize);
        clientMessage.add(initialFrame);
        StringCodec.encode(clientMessage, name);
        ListMultiFrameCodec.encodeNullable(clientMessage, listenerConfigs, ListenerConfigHolderCodec::encode);
        CodecUtil.encodeNullable(clientMessage, splitBrainProtectionName, StringCodec::encode);
        CodecUtil.encodeNullable(clientMessage, queueStoreConfig, QueueStoreConfigHolderCodec::encode);
        StringCodec.encode(clientMessage, mergePolicy);
        CodecUtil.encodeNullable(clientMessage, priorityComparatorClassName, StringCodec::encode);
        return clientMessage;
    }

    public static DynamicConfigAddQueueConfigCodec.RequestParameters decodeRequest(ClientMessage clientMessage) {
        ClientMessage.ForwardFrameIterator iterator = clientMessage.frameIterator();
        RequestParameters request = new RequestParameters();
        ClientMessage.Frame initialFrame = iterator.next();
        request.backupCount = decodeInt(initialFrame.content, REQUEST_BACKUP_COUNT_FIELD_OFFSET);
        request.asyncBackupCount = decodeInt(initialFrame.content, REQUEST_ASYNC_BACKUP_COUNT_FIELD_OFFSET);
        request.maxSize = decodeInt(initialFrame.content, REQUEST_MAX_SIZE_FIELD_OFFSET);
        request.emptyQueueTtl = decodeInt(initialFrame.content, REQUEST_EMPTY_QUEUE_TTL_FIELD_OFFSET);
        request.statisticsEnabled = decodeBoolean(initialFrame.content, REQUEST_STATISTICS_ENABLED_FIELD_OFFSET);
        request.mergeBatchSize = decodeInt(initialFrame.content, REQUEST_MERGE_BATCH_SIZE_FIELD_OFFSET);
        request.name = StringCodec.decode(iterator);
        request.listenerConfigs = ListMultiFrameCodec.decodeNullable(iterator, ListenerConfigHolderCodec::decode);
        request.splitBrainProtectionName = CodecUtil.decodeNullable(iterator, StringCodec::decode);
        request.queueStoreConfig = CodecUtil.decodeNullable(iterator, QueueStoreConfigHolderCodec::decode);
        request.mergePolicy = StringCodec.decode(iterator);
        if (iterator.hasNext()) {
            request.priorityComparatorClassName = CodecUtil.decodeNullable(iterator, StringCodec::decode);
            request.isPriorityComparatorClassNameExists = true;
        } else {
            request.isPriorityComparatorClassNameExists = false;
        }
        return request;
    }

    public static ClientMessage encodeResponse() {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[RESPONSE_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, RESPONSE_MESSAGE_TYPE);
        clientMessage.add(initialFrame);

        return clientMessage;
    }
}
