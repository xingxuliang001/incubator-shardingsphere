/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.core.extractor.impl.common.index;

import com.google.common.base.Optional;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.shardingsphere.sql.parser.core.extractor.api.OptionalSQLSegmentExtractor;
import org.apache.shardingsphere.sql.parser.core.extractor.util.ExtractorUtils;
import org.apache.shardingsphere.sql.parser.core.extractor.util.RuleName;
import org.apache.shardingsphere.sql.parser.sql.segment.ddl.index.IndexSegment;
import org.apache.shardingsphere.sql.parser.sql.value.identifier.IdentifierValue;

import java.util.Map;

/**
 * Index extractor.
 */
public final class IndexExtractor implements OptionalSQLSegmentExtractor {
    
    @Override
    public Optional<IndexSegment> extract(final ParserRuleContext ancestorNode, final Map<ParserRuleContext, Integer> parameterMarkerIndexes) {
        Optional<ParserRuleContext> indexNameNode = ExtractorUtils.findFirstChildNode(ancestorNode, RuleName.INDEX_NAME);
        if (indexNameNode.isPresent()) {
            return Optional.of(new IndexSegment(indexNameNode.get().getStart().getStartIndex(), indexNameNode.get().getStop().getStopIndex(), new IdentifierValue(indexNameNode.get().getText())));
        }
        return Optional.absent();
    }
}
