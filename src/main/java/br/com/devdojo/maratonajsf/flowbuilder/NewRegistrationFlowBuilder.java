package br.com.devdojo.maratonajsf.flowbuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewRegistrationFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newregistration";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/newregistration/newregistration.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newregistration/newregistration2.xhtml");
        flowBuilder.viewNode(flowId, "/newregistration/newregistration3.xhtml");
        flowBuilder.flowCallNode("callNewPendencies")
                   .flowReference("","newpendencies")
                   .outboundParameter("nomeUsuario", "#{testeFlowBuilderBean.nome}")
                   .outboundParameter("sobrenomeUsuario", "#{testeFlowBuilderBean.sobrenome}");
        flowBuilder.returnNode("exitToNewBegin").fromOutcome("/inicioflow.xhtml");
        flowBuilder.finalizer("#{testeFlowBuilderBean.salvar()}");
        return flowBuilder.getFlow();
    }
}
