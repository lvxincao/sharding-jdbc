/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
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
package com.alibaba.druid.sql.ast.expr;

import com.alibaba.druid.sql.ast.SQLExprImpl;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class SQLBinaryExpr extends SQLExprImpl implements SQLLiteralExpr {
    
    private final String value;
    
    @Override
    public void acceptInternal(final SQLASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }
    
    @Override
    public void output(final StringBuffer buffer) {
        buffer.append("b'");
        buffer.append(value);
        buffer.append('\'');
    }
}