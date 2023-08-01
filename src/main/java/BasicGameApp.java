import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.texture.Texture;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;
import com.almasb.fxgl.core.collection.PropertyMap;


import com.almasb.fxgl.app.FXGLApplication;

public class BasicGameApp extends GameApplication{

  private Entity player;
  private Entity block1;

  @Override
  protected void initSettings(GameSettings settings) {
    settings.setWidth(600);
    settings.setHeight(600);
    settings.setTitle("Basic Game App");
    settings.setVersion("0.1");
  }

  public void initGame() {

    player = FXGL.entityBuilder()
        .at(300, 300)
        .view(new Rectangle(25, 25, Color.BLUE))
        .buildAndAttach();




  }

  @Override
  protected void initInput() {
    Input input = FXGL.getInput();

    input.addAction(new UserAction("Move Right") {
      @Override
      protected void onAction() {
        player.translateX(5); // move right 5 pixels
        FXGL.inc("pixelsMoved", 5);
      }
    }, KeyCode.D);

    input.addAction(new UserAction("Move Left") {
      @Override
      protected void onAction() {
        player.translateX(-5); // move left 5 pixels
        FXGL.inc("pixelsMoved", 5);
      }
    }, KeyCode.A);

    input.addAction(new UserAction("Move Up") {
      @Override
      protected void onAction() {
        player.translateY(-5); // move up 5 pixels
        FXGL.inc("pixelsMoved", 5);
      }
    }, KeyCode.W);

    input.addAction(new UserAction("Move Down") {
      @Override
      protected void onAction() {
        player.translateY(5); // move down 5 pixels
        FXGL.inc("pixelsMoved", 5);
      }
    }, KeyCode.S);
  }

  @Override
  protected void initUI() {
    Text textPixels = new Text();
    textPixels.setTranslateX(50); // x = 50
    textPixels.setTranslateY(100); // y = 100

    textPixels.textProperty().bind(FXGL.getip("pixelsMoved").asString("Pixels Moved: %d"));

    FXGL.getGameScene().addUINode(textPixels); // add to the scene graph

    Texture dirtTexture = FXGL.getAssetLoader().loadTexture("dirt.png");
    dirtTexture.setFitHeight(50);
    dirtTexture.setFitWidth(50);
    dirtTexture.setTranslateX(50);
    dirtTexture.setTranslateY(450);

    FXGL.getGameScene().addUINode(dirtTexture);
  }

  @Override
  protected void initGameVars(Map<String, Object> vars) {
    vars.put("pixelsMoved", 0);
  }


  public static void main(String[] args) {
    launch(args);

  }
}
