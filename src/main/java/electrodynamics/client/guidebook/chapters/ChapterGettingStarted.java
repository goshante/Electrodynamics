package electrodynamics.client.guidebook.chapters;

import java.util.ArrayList;
import java.util.List;

import electrodynamics.client.guidebook.utils.ImageWrapperObject;
import electrodynamics.client.guidebook.utils.TextWrapperObject;
import electrodynamics.client.guidebook.utils.components.Chapter;
import electrodynamics.client.guidebook.utils.components.Page;
import electrodynamics.prefab.utilities.TextUtils;
import net.minecraft.network.chat.MutableComponent;

public class ChapterGettingStarted extends Chapter {

	private static final ImageWrapperObject LOGO = new ImageWrapperObject(10, 50, 0, 0, 32, 32, 32, 32,
			"textures/item/map.png");

	@Override
	protected List<Page> genPages() {
		List<Page> pages = new ArrayList<>();

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p1l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p2l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p3l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p4l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p5l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p6l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p7l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p8l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p9l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l6")),
				new TextWrapperObject(10, 100, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l7")),
				new TextWrapperObject(10, 110, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l8")),
				new TextWrapperObject(10, 120, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l9")),
				new TextWrapperObject(10, 130, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l10")),
				new TextWrapperObject(10, 140, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l11")),
				new TextWrapperObject(10, 150, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l12")),
				new TextWrapperObject(10, 160, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l13")),
				new TextWrapperObject(10, 170, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l14")),
				new TextWrapperObject(10, 180, 4210752, TextUtils.guidebook("chapter.gettingstarted.p10l15")) }));

		pages.add(new Page(new TextWrapperObject[] {
				new TextWrapperObject(10, 40, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l1")),
				new TextWrapperObject(10, 50, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l2")),
				new TextWrapperObject(10, 60, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l3")),
				new TextWrapperObject(10, 70, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l4")),
				new TextWrapperObject(10, 80, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l5")),
				new TextWrapperObject(10, 90, 4210752, TextUtils.guidebook("chapter.gettingstarted.p11l6")) }));

		return pages;
	}

	@Override
	public ImageWrapperObject getLogo() {
		return LOGO;
	}

	@Override
	public MutableComponent getTitle() {
		return TextUtils.guidebook("chapter.gettingstarted");
	}

}
