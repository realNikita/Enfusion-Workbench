package com.flipperplz.enfusionWorkbench.languages.param.psi

import com.intellij.psi.util.parentOfType

interface ParamScope : ParamNamedElement {
    val scope: Int
        get() = (previousScope?.scope ?: 0) + 1
    val previousScope: ParamScope?
        get() = parentOfType(false)
    val statements: List<ParamStatement>
    override val binarizable: Boolean
        get() = true

    infix fun getChildClass(className: String?): ParamClass? {
        return if(className == null) null else
            statements.filterIsInstance<ParamClass>().firstOrNull { className.equals(it.className.name, true) && !it.isExternalClass }
    }

    infix fun append(paramStatement: ParamStatement) = node.addChild(paramStatement.node, statements.last().node)

    infix fun getChildExternalClass(className: String?): ParamClass? {
        return if(className == null) null else
            statements.filterIsInstance<ParamClass>().firstOrNull { className.equals(it.className.name, true) && it.isExternalClass }
    }

    infix fun getNamedStatement(statementName: String?): ParamNamedStatement? {
        return if(statementName == null) null else
            statements.filterIsInstance<ParamNamedStatement>().firstOrNull { it.name.equals(statementName, true) }
    }

    infix fun getParam(paramName: String?): ParamAssignment? {
        return if(paramName == null) null else
            statements.filterIsInstance<ParamAssignment>().firstOrNull { it.name.equals(paramName, true) && !it.isArrayAssignment()}
    }

    infix fun getArrayParam(paramName: String?): ParamAssignment? {
        return if(paramName == null) null else
            statements.filterIsInstance<ParamAssignment>().firstOrNull { it.name.equals(paramName, true) && it.isArrayAssignment()}
    }
}