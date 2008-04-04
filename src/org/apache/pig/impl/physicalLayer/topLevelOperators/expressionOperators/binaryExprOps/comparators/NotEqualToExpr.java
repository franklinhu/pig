/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.impl.physicalLayer.topLevelOperators.expressionOperators.binaryExprOps.comparators;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.OperatorKey;
import org.apache.pig.impl.logicalLayer.parser.ParseException;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.impl.physicalLayer.POStatus;
import org.apache.pig.impl.physicalLayer.Result;
import org.apache.pig.impl.physicalLayer.plans.ExprPlanVisitor;

public class NotEqualToExpr extends ComparisonOperator {

    private final Log log = LogFactory.getLog(getClass());

    public NotEqualToExpr(OperatorKey k) {
        this(k, -1);
    }

    public NotEqualToExpr(OperatorKey k, int rp) {
        super(k, rp);
    }

    @Override
    public void visit(ExprPlanVisitor v) throws ParseException {
        v.visitNotEqualTo(this);
    }

    @Override
    public String name() {
        return "Not Equal To - " + mKey.toString();
    }

    @Override
    public Result getNext(DataByteArray inp) throws ExecException {
        byte status;
        Result res;

        DataByteArray left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (DataByteArray) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (DataByteArray) res.result;

        int ret = left.compareTo(right);
        if (ret != 0) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Double inp) throws ExecException {
        byte status;
        Result res;

        Double left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Double) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Double) res.result;

        if (left != right) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Float inp) throws ExecException {
        byte status;
        Result res;

        Float left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Float) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Float) res.result;

        if (left != right) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Integer inp) throws ExecException {
        byte status;
        Result res;

        Integer left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Integer) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Integer) res.result;

        if (left != right) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Long inp) throws ExecException {
        byte status;
        Result res;

        Long left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Long) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Long) res.result;

        if (left != right) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(String inp) throws ExecException {
        byte status;
        Result res;

        String left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (String) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (String) res.result;

        int ret = left.compareTo(right);
        if (ret != 0) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Boolean inp) throws ExecException {
        byte status;
        Result res;

        Boolean left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Boolean) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Boolean) res.result;

        if (!left.equals(right)) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(DataBag inp) throws ExecException {
        byte status;
        Result res;

        DataBag left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (DataBag) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (DataBag) res.result;

        int ret = left.compareTo(right);
        if (ret != 0) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Map inp) throws ExecException {
        byte status;
        Result res;

        Map left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Map) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Map) res.result;

        int ret = DataType.compare(left, right);
        if (ret != 0) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }

    @Override
    public Result getNext(Tuple inp) throws ExecException {
        byte status;
        Result res;

        Tuple left = null, right = null;

        res = lhs.getNext(left);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        left = (Tuple) res.result;

        res = rhs.getNext(right);
        status = res.returnStatus;
        if (status != POStatus.STATUS_OK) {

            return res;
        }
        right = (Tuple) res.result;

        int ret = left.compareTo(right);
        if (ret != 0) {

            res.result = new Boolean(true);
            //left = right = null;
            return res;
        } else {

            res.result = new Boolean(false);
            //left = right = null;
            return res;
        }
    }
}
