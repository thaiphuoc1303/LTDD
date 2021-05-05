// Generated code from Butter Knife. Do not modify!
package it.feio.android.omninotes.intro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import it.feio.android.omninotes.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntroSlide6_ViewBinding implements Unbinder {
  private IntroSlide6 target;

  @UiThread
  public IntroSlide6_ViewBinding(IntroSlide6 target, View source) {
    this.target = target;

    target.background = Utils.findRequiredView(source, R.id.intro_background, "field 'background'");
    target.title = Utils.findRequiredViewAsType(source, R.id.intro_title, "field 'title'", TextView.class);
    target.image_gplus = Utils.findRequiredViewAsType(source, R.id.intro_image_community_googleplus, "field 'image_gplus'", ImageView.class);
    target.image_facebook = Utils.findRequiredViewAsType(source, R.id.intro_image_community_facebook, "field 'image_facebook'", ImageView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.intro_description, "field 'description'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntroSlide6 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.background = null;
    target.title = null;
    target.image_gplus = null;
    target.image_facebook = null;
    target.description = null;
  }
}
