package com.plugtree.workbench.cleareditor.client.widgets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kie.workbench.common.screens.explorer.client.widgets.BaseViewPresenter;
import org.kie.workbench.common.screens.explorer.client.widgets.View;
import org.kie.workbench.common.screens.explorer.service.Option;

/**
 * Asset Viewer 
 */
@ApplicationScoped
public class SingleBusinessViewPresenterImpl extends BaseViewPresenter {

    @Inject
    protected P3BusinessViewWidget view;

    private Set<Option> options = new HashSet<Option>( Arrays.asList( Option.BUSINESS_CONTENT, Option.TREE_NAVIGATOR, Option.EXCLUDE_HIDDEN_ITEMS ) );

    @Override
    protected void setOptions( Set<Option> options ) {
        this.options = new HashSet<Option>( options );
    }

    @Override
    public Set<Option> getActiveOptions() {
        return options;
    }

    @Override
    protected View getView() {
        return view;
    }
}
